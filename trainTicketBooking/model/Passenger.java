package trainTicketBooking.model;

public class Passenger {
	int id;
	String name;
	byte age;
	String gender;
	public Passenger(String name, byte age, String gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
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

