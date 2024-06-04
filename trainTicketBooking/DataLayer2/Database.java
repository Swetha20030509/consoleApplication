package trainTicketBooking.DataLayer2;

import trainTicketBooking.login.Loginmodel;
import trainTicketBooking.model.Booking;
import trainTicketBooking.model.Passenger;
import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;
import trainTicketBooking.model.User;

import java.util.ArrayList;

public class Database {
    static int id=0;
    ArrayList<User> userArrayList=new ArrayList<>();
    ArrayList<Train> allTrain=new ArrayList<>();
    ArrayList<Route> routes=new ArrayList<>();
    ArrayList<Passenger> allpassenger=new ArrayList<>();
    ArrayList<Booking> allBooking=new ArrayList<>();
    User currentuser=null;
    public User getCurrentUser()
    {
    	return currentuser;
    }
    public ArrayList<Booking> getAllBooking() {
		return allBooking;
	}

	public void setAllBooking(ArrayList<Booking> allBooking) {
		this.allBooking = allBooking;
	}

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

	

	public void addPassenger(Passenger passenger) {
		
		allpassenger.add(passenger);
	}

	public void removePassenger(int num) {
		allpassenger.remove(num-1);
		
		
	}

	public ArrayList<Passenger> getPassenger() {
		return allpassenger;
	}

	public void addBooking(Booking book) {
		allBooking.add(book);
		
	}

	public void setCurrentUser(User user) {
		currentuser=user;
		
	}
	
}
