public class Customer {
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;
    private int reservationNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    @Override
    public String toString(){
        return "Full name: %s %s\n age %d\ncontact phone number: %s".formatted(name,surname,age,phoneNumber);
    }
}
