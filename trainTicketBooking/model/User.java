package trainTicketBooking.model;

public class User {
    int id;
    String name;
    int password;
    String phoneNumber;

    public User(int i, String name, String phoneNum, int password) {
        this.name=name;
        this.phoneNumber=phoneNum;
        this.password=password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
