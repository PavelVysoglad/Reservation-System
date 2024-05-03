import java.util.ArrayList;
import java.util.Scanner;

public class ReservationPortal {
    Database database;
    Scanner scanner = new Scanner(System.in);
    public ReservationPortal(){
        database = new Database();
    }

    /**
     * Base for all reservation numbers
     * only usefull while program doesn´t save data after exit
     * Will be solved later on
     */
    int reservationNumberBase= 100000;

    /**
     * Methods to decrease ammount of code
     * Entering name and destionations occures more than one time
     * @return
     */
    public String enterFirstName(){
        System.out.println("Please enter first name:");
        return scanner.nextLine().trim();
    }
    public String enterSurname(){
        System.out.println("Please enter surname:");
        return scanner.nextLine().trim();
    }
    public String enterBoarding(){
        System.out.println("Please enter boarding city:");
        return scanner.nextLine().trim();
    }
    public String enterDestination(){
        System.out.println("Please enter flight destination:");
        return scanner.nextLine().trim();
    }

    /**
     * For now solves auto-increment of reservation numbers
     */
    public void incrementReservationNumber(){
        reservationNumberBase++;
    }

    /**
     * Welcoming line
     */
    public void openingStatement(){
        System.out.println("Welcome to the Reservation system v.1.0.0");
        System.out.println();
    }

    /**
     * Console menu
     */
    public void openingMenu(){
        System.out.println("Plese select action.");
        System.out.println();
        System.out.println("1 - create new reservation");
        System.out.println("2 - search reservations by full name");
        System.out.println("3 - search reservation via reservation number");
        System.out.println("4 - search reservation via transit ");
        System.out.println("5 - list all reservations");
        System.out.println("9 - close tab");
    }

    /**
     * Find passanger and reservation by passangers full name
     * first if statement solves wether name or surname input is empty
     * if so, will print coresponding response
     *
     * second if statement deals with ammount of found reservations with same full name
     * if there is exactly one, cirresponding message is displayed with reservation informations
     * >1 identical names will display this fact and also list all the reservations under this full name.
     * ==0 will declare that no resolutes were found
     */
    public void findReservationByFullName() {
        String name = enterFirstName();
        String surname = enterSurname();
        if (name.isEmpty() || surname.isEmpty()){
            System.out.println("action could not be forwarded, make sure you enter name and surname");
        }else {

            ArrayList<Customer> customers = database.getCustomersByFullName(name, surname);
            if (customers.size() == 1) {
             for(Customer customer: customers) {
                 System.out.println("Customer was found:");
                 System.out.println(customer);
                 int concreteReservationNumber = customer.getReservationNumber();
                 System.out.println(database.getReservationByReservationNumber(concreteReservationNumber));
             }
            } else if(customers.size() > 1){
                System.out.println(customers.size()+" customers with identical name has been found");
                for(Customer customer : customers){
                    System.out.println(customer);
                    int concreteReservationNumber = customer.getReservationNumber();
                    System.out.println(database.getReservationByReservationNumber(concreteReservationNumber));
                    System.out.println();
                }
            } else {
                System.out.println("No Customers with searched name has been found.\n Please make sure you entered the correct name and surname");
            }
        }
    }

    /**
     * Display reservation with coresponding reservation number
     */
    public void findReservationByReservationNumber(){
        System.out.println("Please enter reservation number");
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println(database.getCustomersByReservationNumber(input));
        System.out.println(database.getReservationByReservationNumber(input));
    }

    /**
     * Display all reservations with same place of origin and destination
     */
    public void fndCustomerByTransit (){
        String boarding = enterBoarding();
        String destination = enterDestination();
        ArrayList<Reservation> reservations = database.getReservationsByTransit(boarding,destination);
        for (Reservation reservation: reservations){
            int concreteReservationNumber = reservation.getReservationNumber();
            System.out.println(database.getCustomersByReservationNumber(concreteReservationNumber));
            System.out.println(reservation);
        }
    }

    /**
     * Creates Customer and Reservation instance
     * Method will first ask for all inputs needed for database methods
     * then will create both instances and use method for incrementing reservation number
     */
    public void createCustomer(){
        int reservationNumber = reservationNumberBase;
        String name = enterFirstName();
        String surname = enterSurname();
        System.out.println("Please enter passangers age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter passangers phone number:");
        String phoneNumber = scanner.nextLine().trim();
        String boarding = enterBoarding();
        String destination = enterDestination();
        database.createNewCustomer(name,surname,age,phoneNumber,reservationNumber);
        database.createNewReservation(boarding,destination,reservationNumber);
        incrementReservationNumber();
        System.out.println("Passanger with following informations was added:");
        System.out.println(name+" "+surname+" - age: "+age);
        System.out.println("Contact phone: "+phoneNumber);
        System.out.println("Boarding at :"+boarding+" - Flight destination: "+destination);
    }

    /**
     * Writes all passangers from evidence
     * later will be expanded by displaying reservation informations as well
     * will match Passanger with reservation via reservation number
     */
    public void writeOutEvidence(){
        ArrayList<Customer> customers = database.writeAllCustomers();
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
}
