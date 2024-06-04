package trainTicketBooking.login;

import trainTicketBooking.DataLayer2.Database;
import trainTicketBooking.model.User;

import java.util.ArrayList;

public class Loginmodel {
    public static Database database;
    Loginmodel()
    {
    database=new Database(this);
    }

    public boolean isUser(String phoneNumber,int password) {
        ArrayList<User> users=database.getUser();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getPhoneNumber().equals(phoneNumber)&&users.get(i).getPassword()==password)
            {
            	database.setCurrentUser(users.get(i));
                return true;
            }
        }
        return false;
    }

    public void addUser(String name, String phoneNum, int password) {

        database.addUser(name,phoneNum,password);
    }

    public boolean isAdmin(String phoneNumber,int password) {
        if(phoneNumber.equals("9750685238")&&password==1234)
            return true;
        return false;
    }

    public void showTrains() {
    }
}
