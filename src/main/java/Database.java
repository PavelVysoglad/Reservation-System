import java.util.ArrayList;

public class Database {
    private ArrayList<Customer> customers;
    private ArrayList<Reservation> reservations;

    public Database(){
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void createNewCustomer(String name, String surname, int age, String phoneNumber, int reservationNumber ){
        customers.add(new Customer(name,surname,age,phoneNumber,reservationNumber));
    }


    public void createNewReservation(String flightOrigin, String flightDestination, int reservationNumber) {
    reservations.add(new Reservation(flightOrigin,flightDestination,reservationNumber));
    }

    public ArrayList<Customer> getCustomersByFullName(String name, String surname) {
    ArrayList<Customer> found = new ArrayList<>();
    for (Customer customer : customers){
        if((name.equalsIgnoreCase(customer.getName())) && (surname.equalsIgnoreCase(customer.getSurname()))) {
            found.add(customer);
        }
    }
    return found;
    }
    public ArrayList<Reservation> getReservationsByTransit(String flightOrigin, String flightDestination){
        ArrayList<Reservation> found = new ArrayList<>();
        for(Reservation reservations: reservations){
            if((flightOrigin.equalsIgnoreCase(reservations.getFlightOrigin())) && (flightDestination.equalsIgnoreCase(reservations.getFlightDestination()))){
                found.add(reservations);
            }
        }
        return found;
    }

    public ArrayList<Customer> getCustomersByReservationNumber(int reservationNumber){
        ArrayList<Customer> found = new ArrayList<>();
        for(Customer customer : customers){
            if(reservationNumber == customer.getReservationNumber()){
                found.add(customer);
            }
        }
        return found;
    }
    public ArrayList<Reservation> getReservationByReservationNumber(int reservationNumber){
        ArrayList<Reservation> found = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservationNumber == reservation.getReservationNumber()){
                found.add(reservation);
            }
        }
        return found;
    }
    public ArrayList<Customer> writeAllCustomers(){
        ArrayList<Customer> found = new ArrayList<>(customers);
        return found;
    }
}
