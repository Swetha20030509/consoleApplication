package trainTicketBooking.DataLayer2;

import trainTicketBooking.login.Loginmodel;
import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;
import trainTicketBooking.model.User;

import java.util.ArrayList;

public class Database {
    static int id=0;
    ArrayList<User> userArrayList=new ArrayList<>();
    ArrayList<Train> allTrain=new ArrayList<>();
    ArrayList<Route> routes=new ArrayList<>();
    public Database(Loginmodel loginmodel) {
    }

    public ArrayList<User> getUser() {
        return userArrayList;

    }

    public void addUser(String name, String phoneNum, int password) {
        User user=new User(++id,name,phoneNum,password);
        userArrayList.add(user);
    }

    public boolean addTrain(Train train) {
        return allTrain.add(train);

    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public ArrayList<Train> getTrains() {
        return allTrain;
    }

    public ArrayList<Route> getRoutes() {
        return  routes;
    }
}
