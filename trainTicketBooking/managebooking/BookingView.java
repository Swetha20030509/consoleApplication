package trainTicketBooking.managebooking;

import trainTicketBooking.login.Loginview;
import trainTicketBooking.model.Booking;
import trainTicketBooking.model.Passenger;
import trainTicketBooking.model.Train;
import trainTicketBooking.model.searchResult;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingView {
    static int pnr = 1;
    static int ticket = 1;
    Scanner sc = new Scanner(System.in);
    Loginview loginview;
    BookingModel bookingModel;

    public BookingView(Loginview loginview) {
        this.loginview = loginview;
        bookingModel = new BookingModel(this);
    }

    public void processBooking(Train train, int passenger) {
        for (int i = 0; i < passenger; i++) {
            System.out.println("Enter the name");
            String name = sc.next();
            System.out.println("Enter the age");
            byte age = sc.nextByte();
            System.out.println("Enter the gender");
            String gender = sc.next();
            int count = train.getSeat();
            if (train.getSeat() > 0) {
                bookingModel.addPassenger(ticket++, name, age, gender, "Confirmed");
                train.setSeat(--count);
            } else {
                bookingModel.addWaitingList(ticket++, name, age, gender, "WaitingList");
            }
        }
        for (int i = 0; i < bookingModel.getPassenger().size(); i++) {
            System.out.println("----------------------------");
            System.out.printf("%-15s| %-15s| %-15s", "passenger", "Name", "Age");
            System.out.println();
            System.out.printf("%-15d| %-15s| %-15s", i + 1, bookingModel.getPassenger().get(i).getName(), bookingModel.getPassenger().get(i).getAge());
            System.out.println();
            System.out.println("----------------------------");
        }
        System.out.println("Total Amount :" + train.getAmount() * passenger);
        System.out.println("Do you want to any cancel Ticket(yes/no)");
        String option = sc.next();
        if (option.toLowerCase().equals("yes")) {
            System.out.println("Enter the passenger number to cancel");
            int num = sc.nextInt();
            bookingModel.removePassenger(num);
        }
        bookingModel.addBooking(train.getNumber(), "ABC" + pnr, bookingModel.getPassenger());
    }

    public void booking() {
        System.out.println("Enter from station");
        String station = sc.next();
        System.out.println("Enter the ToStation");
        String ToStation = sc.next();
        ArrayList<searchResult> detail = bookingModel.searchTrain(station, ToStation);
        System.out.println("------------------------------------------------");
        for (int i = 0; i < detail.size(); i++) {
            if (detail.get(i) != null) {

                System.out.printf("%-15s| %-15s| %-15s| %-15s", "TrainNumber", "Name", "DepatureTime", "ArrivalTime");
                System.out.println();
                System.out.printf("%-15d| %-15s| %-15s|%-15s", detail.get(i).getUser().getNumber(), detail.get(i).getUser().getName(), detail.get(i).getDepatureTime(), detail.get(i).getArrivalTime());
                System.out.println();
            }
        }
        System.out.println("------------------------------------------------");
        if (detail.size() > 0) {
            System.out.println("Enter the train number");
            int number = sc.nextInt();
            System.out.println("Enter the number of passenger");
            int passenger = sc.nextInt();
            Train train = bookingModel.isAvailable(number, passenger);
            if (train != null) {
                processBooking(train, passenger);
            }
        }
    }

    public void sendMessage(String string) {
        System.out.println(string);
    }

    public void myBooking() {

        for (int i = 0; i < bookingModel.getBookingDetail().size(); i++) {
            if (bookingModel.getUser().getId() == bookingModel.getBookingDetail().get(i).getId()) {
                System.out.println("PNR :" + bookingModel.getBookingDetail().get(i).getPnr());
                System.out.println("--------------------------------------");
                for (int j = 0; j < bookingModel.getBookingDetail().get(i).getPassengerList().size(); j++) {
                    System.out.printf("%-15s| %-15s| %-15s", "Ticket no", "Name", "Status");
                    System.out.println();
                    System.out.printf("%-15d| %-15s| %-15s", bookingModel.getBookingDetail().get(i).getPassengerList().get(j).getId(), bookingModel.getBookingDetail().get(i).getPassengerList().get(j).getName(), bookingModel.getBookingDetail().get(i).getPassengerList().get(j).getStatus());
                    System.out.println();
                }
                System.out.println("--------------------------------------");
            }
        }
        System.out.println("1.Cancel");
        System.out.println("2.Exit");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the pnr number");
                String pnr = sc.next();
                Booking booking = bookingModel.getBooking(pnr);
                boolean flag = bookingModel.removewatingList();
                System.out.println("Enter the Ticket No");
                int id = sc.nextInt();
                bookingModel.cancelBooking(booking.getPassengerList(), id);
                if (!flag)
                    bookingModel.setTrainCount(booking.getTrainNumber());
                break;
            case 2:
                loginview.usermenu();
                break;
        }
    }
}
