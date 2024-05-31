package trainTicketBooking.managebooking;

import trainTicketBooking.DataLayer2.Database;
import trainTicketBooking.login.Loginmodel;
import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;
import trainTicketBooking.model.searchResult;

import java.util.ArrayList;

public class BookingModel {
    public BookingModel(BookingView bookingView) {
    }

    public ArrayList<searchResult>  searchTrain(String station, String toStation) {
        ArrayList<Train> alltrain=Loginmodel.database.getTrains();
        ArrayList<Route> allroute=Loginmodel.database.getRoutes();
        ArrayList<searchResult> trains = new ArrayList<>();

        for(int i=0;i<alltrain.size();i++)
        {   searchResult SearchResult=new searchResult();
            for(int j=0;j<allroute.size();j++)
            {
                if(alltrain.get(i).getNumber()==allroute.get(j).getTrainNumber()&&(allroute.get(j).getName().equals(station)))
                {
                    SearchResult.setFrom(allroute.get(i).getName());
                    SearchResult.setUser(alltrain.get(i));
                   SearchResult.setArrivalTime(allroute.get(i).getTime());
                }
                else {
                    SearchResult.setTo(station);
                    SearchResult.setDepatureTime(allroute.get(j).getTime());
                }
            }
            trains.add(SearchResult);
        }
        return trains;
    }

    public boolean isAvailable(int number,int tickets) {
        Loginmodel.database.getTrains();
        for(int i=0;i<Loginmodel.database.getTrains().size();i++)
        {
            if(number==Loginmodel.database.getTrains().get(i).getNumber())
            {
                if(Loginmodel.database.getTrains().get(i).getSeat()>=tickets)
                    return true;
            }
        }
        return false;
    }
}
