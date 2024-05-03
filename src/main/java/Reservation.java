import java.util.ArrayList;

/**
 * System at this point works only with flight origin and destination
 * Te param @ reservation number is shared with Customer class
 *                                  Will be used in SQL database later in the line
 */
public class Reservation {
    private String flightOrigin;
    private String flightDestination;
    private int reservationNumber;

    /**
     * Reservation constructor
     * @param flightOrigin
     * @param flightDestination
     * @param reservationNumber
     */
    public Reservation(String flightOrigin, String flightDestination, int reservationNumber){
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.reservationNumber = reservationNumber;
    }

    /**
     * Getters in use
     * Setters not yet implemented in Portal class
     * @return
     */
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
