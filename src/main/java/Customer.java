public class Customer {
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;
    private int reservationNumber;

    /**
     * Customer constructor
     * @param name
     * @param surname
     * @param age
     * @param phonenumber
     * @param reservationNumber
     */
    public Customer(String name, String surname, int age, String phonenumber, int reservationNumber){
     this.name = name;
     this.surname = surname;
     this.age = age;
     this.phoneNumber = phonenumber;
     this.reservationNumber = reservationNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    @Override
    public String toString(){
        return "Full name: %s %s\n age %d\ncontact phone number: %s".formatted(name,surname,age,phoneNumber);
    }
}
