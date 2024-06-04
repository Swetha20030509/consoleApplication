package trainTicketBooking.managebooking;

import trainTicketBooking.login.Loginview;
import trainTicketBooking.model.Passenger;
import trainTicketBooking.model.searchResult;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingView {
	static int pnr=1;
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
        System.out.println("----------------------------------------------------------");
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
                    byte age=sc.nextByte();
                    System.out.println("Enter the gender");
                    String gender=sc.next();
                    bookingModel.addPassenger(name,age,gender);
                }
                for(int i=0;i<bookingModel.getPassenger().size();i++)
                {
                	System.out.println("----------------------------");
                	System.out.println("passenger "+(i+1));
                	System.out.println("Name :"+bookingModel.getPassenger().get(i).getName());
                	System.out.println("----------------------------");
                }
                System.out.println("Do you want to any cancel Ticket(yes/no)");
                String option=sc.next();
                if(option.toLowerCase().equals("yes")||option.toLowerCase().equals("no"))
                {
                	System.out.println("Enter the passenger number to cancel");
                	int num=sc.nextInt();
                	bookingModel.removePassenger(num);
                }
                bookingModel. addBooking("ABC"+pnr, bookingModel.getPassenger());
            }
        }
    }

	public void sendMessage(String string) {
		System.out.println(string);
		
	}

	public void myBooking() {
		for(int i=0;i<bookingModel.getBookingDetail().size();i++)
		{
			if(bookingModel.getUser().getId()==bookingModel.getBookingDetail().get(i).getId())
			{
				System.out.println("--------------------------------------");
				System.out.println(bookingModel.getBookingDetail().get(i).getPnr());
				for(int j=0;j<bookingModel.getBookingDetail().get(i).getPassengerList().size();j++)
				{
					System.out.println("Name :"+bookingModel.getBookingDetail().get(i).getPassengerList().get(j).getName());
				}
				System.out.println("--------------------------------------");
			}
		}
		
	}

	
}
