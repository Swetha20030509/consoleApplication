package trainTicketBooking.managetrain;

import trainTicketBooking.model.Route;
import trainTicketBooking.model.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainview {
    Scanner sc = new Scanner(System.in);
    Trainmodel trainmodel;

    public Trainview() {
        trainmodel = new Trainmodel(this);
    }

    public void addTrain() {
        System.out.println("Enter the train number");
        int number = sc.nextInt();
        System.out.println("Enter the train name");
        String name = sc.next();
        System.out.println("Enter the train depature time");
        double depatureTime = sc.nextDouble();
        System.out.println("Enter the arrival time");
        double arrivalTime = sc.nextDouble();
        System.out.println("Enter the number of seats");
        int seats = sc.nextInt();
        System.out.println("Enter the amount");
        int amount = sc.nextInt();
        if (trainmodel.addTrain(number, name, seats, amount))
            System.out.println("train added sucessfully");
    }

    public void addRoute() {
        System.out.println("Enter the train number");
        int number = sc.nextInt();
        System.out.println("Enter the number of route added");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the name");
            String name = sc.next();
            System.out.println("Enter the time");
            double time = sc.nextDouble();
            trainmodel.addRoute(number, name, time);
        }
    }

    public void showTrains() {
        ArrayList<Train> allTrain = trainmodel.getTains();
        ArrayList<Route> allRoutes = trainmodel.getRoutes();
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < allTrain.size(); i++) {
            name = new ArrayList<>();
            for (int j = 0; j < allRoutes.size(); j++) {
                if (allTrain.get(i).getNumber() == allRoutes.get(j).getTrainNumber()) {
                    name.add(allRoutes.get(j).getName());
                }
            }

            String routes = "";
            for (int k = 0; k < name.size(); k++)
                routes += name.get(k) + "->";
            System.out.println("--------------------------------------");
            System.out.printf("%-15s| %-15s| %-25s| %-15s", "Train Number", "TrainName", "Train routs", "Seats");
            System.out.println();
            System.out.printf("%-15d| %-15s| %-25s| %-15s", allTrain.get(i).getNumber(), allTrain.get(i).getName(), routes, allTrain.get(i).getSeat());
            System.out.println();
            System.out.println("--------------------------------------");
        }
    }
}
