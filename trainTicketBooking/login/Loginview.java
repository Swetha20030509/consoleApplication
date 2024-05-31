package trainTicketBooking.login;

import trainTicketBooking.TrainticketbookingSystem;
import trainTicketBooking.managebooking.BookingView;
import trainTicketBooking.managetrain.Trainview;

import java.util.Scanner;

public class Loginview {
    TrainticketbookingSystem trainticketbookingSystem;
    Loginmodel loginmodel;
    Trainview trainView;
    BookingView bookingView;
    Scanner sc=new Scanner(System.in);
    public Loginview(TrainticketbookingSystem trainticketbookingSystem)
    {
        this.trainticketbookingSystem=trainticketbookingSystem;
        trainView = new Trainview();
        loginmodel=new Loginmodel();
        bookingView=new BookingView(this);
    }

    public void init() {
        while (true) {
            System.out.println("1.Login");
            System.out.println("2.SignUp");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your phone number");
                    String phoneNo = sc.next();
                    System.out.println("Enter your password");
                    int password = sc.nextInt();
                    if (loginmodel.isUser(phoneNo, password))
                        usermenu();
                    else if(loginmodel.isAdmin(phoneNo,password))
                        adminmenu();
                    else
                        System.out.println("Invalid user name and password");
                    break;
                case 2:
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your phone number");
                    String phoneNum = sc.next();
                    System.out.println("create your password");
                    password = sc.nextInt();
                    loginmodel.addUser(name, phoneNum, password);

            }
        }
    }

    private void adminmenu() {
        while(true) {
            System.out.println("1.Add train");
            System.out.println("2.Add route");
            System.out.println("2.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    trainView.addTrain();
                    break;
                case 2:
                    trainView.addRoute();
                    break;
                case 3:
                    init();
                    break;
            }
        }
    }

    private void usermenu() {
       trainView.showTrains();
       System.out.println("1.Booking");
       System.out.println("2.exit");
       int choice=sc.nextInt();
       switch(choice)
       {
           case 1:
               bookingView.booking();
               break;
           case 2:
               init();
               break;
       }
    }
}
