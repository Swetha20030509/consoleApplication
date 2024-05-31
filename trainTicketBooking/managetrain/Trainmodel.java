package trainTicketBooking.managetrain;

import trainTicketBooking.login.Loginmodel;
import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;

import java.util.ArrayList;

public class Trainmodel {
    Trainview trainview;
    public Trainmodel(Trainview trainview) {
        this.trainview=trainview;
    }

    public boolean addTrain(int number, String name, int seats, int amount) {
        Train train=new Train(number,name,seats,amount);
        return Loginmodel.database.addTrain(train);
    }

    public void addRoute(int trainNumber,String name, double time) {
        Route route=new Route(trainNumber,name,time);
        Loginmodel.database.addRoute(route);
    }

    public ArrayList<Train> getTains() {
        return Loginmodel.database.getTrains();
    }

    public ArrayList<Route> getRoutes() {
        return Loginmodel.database.getRoutes();
    }
}
