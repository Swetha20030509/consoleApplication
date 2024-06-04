package trainTicketBooking.managebooking;

import trainTicketBooking.login.Loginmodel;
import trainTicketBooking.model.Booking;
import trainTicketBooking.model.Passenger;
import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;
import trainTicketBooking.model.User;
import trainTicketBooking.model.searchResult;

import java.util.ArrayList;

public class BookingModel {
    BookingView bookingView;

    public BookingModel(BookingView bookingView) {
        this.bookingView = bookingView;
    }

    public ArrayList<searchResult> searchTrain(String station, String toStation) {
        ArrayList<Train> alltrain = Loginmodel.database.getTrains();
        ArrayList<Route> allroute = Loginmodel.database.getRoutes();
        ArrayList<searchResult> trains = new ArrayList<>();

        for (int i = 0; i < alltrain.size(); i++) {
            searchResult SearchResult = new searchResult();
            for (int j = 0; j < allroute.size(); j++) {
                if (alltrain.get(i).getNumber() == allroute.get(j).getTrainNumber() && (allroute.get(j).getName().equals(station))) {
                    SearchResult.setFrom(allroute.get(i).getName());
                    SearchResult.setUser(alltrain.get(i));
                    SearchResult.setArrivalTime(allroute.get(i).getTime());
                } else {
                    SearchResult.setTo(station);
                    SearchResult.setDepatureTime(allroute.get(j).getTime());
                }
            }
            trains.add(SearchResult);
        }
        return trains;
    }

    public Train isAvailable(int number, int tickets) {
        Loginmodel.database.getTrains();
        for (int i = 0; i < Loginmodel.database.getTrains().size(); i++) {
            if (number == Loginmodel.database.getTrains().get(i).getNumber()) {
                if (Loginmodel.database.getTrains().get(i).getSeat() >= tickets)
                    return Loginmodel.database.getTrains().get(i);
                else
                    return Loginmodel.database.getTrains().get(i);
            }

        }
        return null;
    }

    public void addPassenger(int i, String name, byte age, String gender, String confirmed) {
        Passenger passenger = new Passenger(i, name, age, gender, confirmed);
        Loginmodel.database.addPassenger(passenger);


    }

    public void removePassenger(int num) {
        Loginmodel.database.removePassenger(num);

    }

    public ArrayList<Passenger> getPassenger() {
        return Loginmodel.database.getPassenger();

    }

    public void addBooking(int number, String pnr, ArrayList<Passenger> passenger) {
        if (passenger.size() > 0) {
            Booking book = new Booking(number, getUser().getId(), pnr, passenger);
            Loginmodel.database.addBooking(book);
            bookingView.sendMessage("BOOKING SUCCESSFULLY !!!!!");
        }

    }

    public User getUser() {
        return Loginmodel.database.getCurrentUser();
    }

    public ArrayList<Booking> getBookingDetail() {

        return Loginmodel.database.getAllBooking();
    }


    public boolean addWaitingList(int i, String name, byte age, String gender, String waitingList) {
        if (Loginmodel.database.getWaitingList().size() < 6) {
            Passenger passenger = new Passenger(i, name, age, gender, waitingList);
            Loginmodel.database.addPassenger(passenger);
            Loginmodel.database.addWaitingList(passenger);
            return true;
        } else {
            bookingView.sendMessage("Train is full");
        }
        return false;
    }

    public boolean removewatingList() {
        if (Loginmodel.database.getWaitingList().size() > 0) {
            Loginmodel.database.getWaitingList().get(0).setStatus("Confirmed");
            return true;
        }
        return false;
    }

    public Booking getBooking(String pnr) {
        for (int i = 0; i < Loginmodel.database.getAllBooking().size(); i++) {
            if (pnr.equals(Loginmodel.database.getAllBooking().get(i).getPnr()))
                return Loginmodel.database.getAllBooking().get(i);
        }
        return null;
    }

    public void cancelBooking(ArrayList<Passenger> passengerList, int id) {
        passengerList.get(id - 1).setStatus("cancelled");
    }

    public void setTrainCount(int trainNumber) {
        for (int i = 0; i < Loginmodel.database.getTrains().size(); i++) {
            if (trainNumber == Loginmodel.database.getTrains().get(i).getNumber()) {
                int seat = Loginmodel.database.getTrains().get(i).getSeat();
                Loginmodel.database.getTrains().get(i).setSeat(--seat);
            }
        }
    }
}
