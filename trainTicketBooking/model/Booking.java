package trainTicketBooking.model;

import java.util.ArrayList;

public class Booking {
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	String pnr;
	ArrayList<Passenger> passengerList=new ArrayList<>();
	public Booking(int id, String pnr, ArrayList<Passenger> passenger) {
		this.pnr=pnr;
		this.passengerList=passengerList;
		this.id=id;
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
