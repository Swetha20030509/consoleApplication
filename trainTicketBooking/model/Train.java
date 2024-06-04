package trainTicketBooking.model;

public class Train {
    int number;
    String name;
    int seat;
    int amount;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Train(int number, String name, int seat, int amount) {
        this.number = number;
        this.name = name;
        this.seat = seat;
        this.amount = amount;
    }
}
