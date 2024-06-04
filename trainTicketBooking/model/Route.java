package trainTicketBooking.model;

public class Route {
    String name;
    double time;
    int trainNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Route(int trainNumber, String name, double time) {
        this.trainNumber = trainNumber;
        this.name = name;
        this.time = time;
    }
}
