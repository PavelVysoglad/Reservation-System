import java.util.ArrayList;
import java.util.Scanner;

public class ReservationPortal {
    Database database;
    Scanner scanner = new Scanner(System.in);
    public ReservationPortal(){
        database = new Database();
    }

    int reservationNumberBase= 100000;

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

    public void incrementReservationNumber(){
        reservationNumberBase++;
    }
    public void openingStatement(){
        System.out.println("Welcome to the Reservation system v.1.0.0");
        System.out.println();
    }
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
    public void findReservationByReservationNumber(){
        System.out.println("Please enter reservation number");
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println(database.getCustomersByReservationNumber(input));
        System.out.println(database.getReservationByReservationNumber(input));
    }
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
    public void writeOutEvidence(){
        ArrayList<Customer> customers = database.writeAllCustomers();
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
}
