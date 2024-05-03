import java.util.ArrayList;

public class Database {
    private ArrayList<Customer> customers;
    private ArrayList<Reservation> reservations;

    /**
     * Instane of Database
     * Class which comunicates with Reservation portal class, SO THAT USER DOESN´T DIRECTLY COMUNUCATES WITH DATABASE
     */
    public Database(){
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    /**
     * Adds new Customer instance to ArrayList of customers
     * @param name
     * @param surname
     * @param age
     * @param phoneNumber
     * @param reservationNumber
     */
    public void createNewCustomer(String name, String surname, int age, String phoneNumber, int reservationNumber ){
        customers.add(new Customer(name,surname,age,phoneNumber,reservationNumber));
    }

    /**
     * Adds new Reservation instance to ArrayList of reservations
     * @param flightOrigin
     * @param flightDestination
     * @param reservationNumber
     */
    public void createNewReservation(String flightOrigin, String flightDestination, int reservationNumber) {
    reservations.add(new Reservation(flightOrigin,flightDestination,reservationNumber));
    }

    /**
     * Creates new ArrayList to display all customers with input full name
     * @param name
     * @param surname
     * @return
     */
    public ArrayList<Customer> getCustomersByFullName(String name, String surname) {
    ArrayList<Customer> found = new ArrayList<>();
    for (Customer customer : customers){
        if((name.equalsIgnoreCase(customer.getName())) && (surname.equalsIgnoreCase(customer.getSurname()))) {
            found.add(customer);
        }
    }
    return found;
    }

    /**
     * Creates new ArrayList to display reservations
     * with corresponding place of origin and destination and link the customers with their reservation via reservation number
     *
     * @param flightOrigin
     * @param flightDestination
     * @return
     */
    public ArrayList<Reservation> getReservationsByTransit(String flightOrigin, String flightDestination){
        ArrayList<Reservation> found = new ArrayList<>();
        for(Reservation reservations: reservations){
            if((flightOrigin.equalsIgnoreCase(reservations.getFlightOrigin())) && (flightDestination.equalsIgnoreCase(reservations.getFlightDestination()))){
                found.add(reservations);
            }
        }
        return found;
    }

    /**
     * Finds customer via reservation number
     * @param reservationNumber
     * @return
     */
    public ArrayList<Customer> getCustomersByReservationNumber(int reservationNumber){
        ArrayList<Customer> found = new ArrayList<>();
        for(Customer customer : customers){
            if(reservationNumber == customer.getReservationNumber()){
                found.add(customer);
            }
        }
        return found;
    }

    /**
     * Finds reservation via reservation number
     * @param reservationNumber
     * @return
     */
    public ArrayList<Reservation> getReservationByReservationNumber(int reservationNumber){
        ArrayList<Reservation> found = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservationNumber == reservation.getReservationNumber()){
                found.add(reservation);
            }
        }
        return found;
    }

    /**
     * Display all customers in Arraylist
     * @return
     */
    public ArrayList<Customer> writeAllCustomers(){
        ArrayList<Customer> found = new ArrayList<>(customers);
        return found;
    }
}
