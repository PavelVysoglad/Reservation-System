import java.util.ArrayList;

public class Reservation {
    private String flightOrigin;
    private String flightDestination;
    private int reservationNumber;

    public Reservation(String flightOrigin, String flightDestination, int reservationNumber){
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.reservationNumber = reservationNumber;
    }

    public String getFlightOrigin() {
        return flightOrigin;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    @Override
    public String toString (){
        return "Flying \nfrom: %s \nto %s\nunder reservation number: %d".formatted(flightOrigin,flightDestination,reservationNumber);
    }
}
