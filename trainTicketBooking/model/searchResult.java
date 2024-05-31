package trainTicketBooking.model;

public class searchResult {
    Train train;
    String from;
    String to;
    double depatureTime;
    double arrivalTime;

    public Train getUser() {
        return train;
    }

    public void setUser(Train train) {
        this.train = train;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(double depatureTime) {
        this.depatureTime = depatureTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public searchResult() {
    }
}
