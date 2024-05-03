import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationPortal reservationPortal = new ReservationPortal();
        int input;
        reservationPortal.openingStatement();
        do {
            /**
             * Solved issue of console menu displaying right after last user input
             * solved by short pause before displaying menu
             * in version containing HUD - will not be needed
             */
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reservationPortal.openingMenu();
            input = Integer.parseInt(scanner.nextLine());
            /**
             * Simple switch to navigate user by user input in console
             */
            switch (input){
                case 1:
                    reservationPortal.createCustomer();
                    break;
                case 2:
                    reservationPortal.findReservationByFullName();
                    break;
                case 3:
                    reservationPortal.findReservationByReservationNumber();
                    break;
                case 4:
                    reservationPortal.fndCustomerByTransit();
                case 5:
                    reservationPortal.writeOutEvidence();
                    break;
                case 9:
                    System.out.println("GOOD BYE");
                    break;
                default:
                    System.out.println("Incorrect statement");
            }
        } while (input != 9);
    }
}
