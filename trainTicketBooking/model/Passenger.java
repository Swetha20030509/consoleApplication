package trainTicketBooking.model;

public class Passenger {
    int id;
    String name;
    byte age;
    String gender;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Passenger(int ticket, String name, byte age, String gender, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.id = ticket;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

