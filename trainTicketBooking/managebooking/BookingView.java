package trainTicketBooking.managebooking;

import trainTicketBooking.login.Loginview;
import trainTicketBooking.model.Passenger;
import trainTicketBooking.model.searchResult;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingView {
    Scanner sc=new Scanner(System.in);
    Loginview loginview;
    BookingModel bookingModel;
    public BookingView(Loginview loginview) {
        this.loginview=loginview;
        bookingModel=new BookingModel(this);

    }

    public void booking() {
        System.out.println("Enter from station");
        String station=sc.next();
        System.out.println("Enter the ToStation");
        String ToStation=sc.next();
        ArrayList<searchResult> detail=bookingModel.searchTrain(station,ToStation);
        for(int i=0;i<detail.size();i++)
        {
            if(detail.get(i)!=null)
            {
                System.out.println(detail.get(i).getUser().getNumber());
                System.out.println(detail.get(i).getUser().getName());
                System.out.println(detail.get(i).getDepatureTime());
                System.out.println(detail.get(i).getArrivalTime());
                System.out.println(detail.get(i).getUser().getSeat());
            }
        }
        if(detail.size()>0)
        {
            System.out.println("Enter the train number");
            int number= sc.nextInt();
            System.out.println("Enter the number of passenger");
            int passenger=sc.nextInt();
            boolean flag=bookingModel.isAvailable(number,passenger);
            if(flag) {
                for (int i = 0; i < passenger; i++) {
                    System.out.println("Enter the name");
                    String name= sc.next();
                    System.out.println("Enter the age");

                    Passenger passengers=new Passenger();
                }
            }
        }
    }
}
