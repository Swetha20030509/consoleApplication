package trainTicketBooking.model;

import java.util.ArrayList;

public class Booking {
    int id;
    int trainNumber;

    public Booking(int number, int id, String pnr, ArrayList<Passenger> passenger) {
        this.pnr = pnr;
        this.passengerList = passenger;
        this.id = id;
        this.trainNumber = number;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String pnr;
    ArrayList<Passenger> passengerList = new ArrayList<>();


    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Booking(int id, String pnr, ArrayList<Passenger> passenger) {


    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
