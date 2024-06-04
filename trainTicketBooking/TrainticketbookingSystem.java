package trainTicketBooking;

import trainTicketBooking.login.Loginview;
import trainTicketBooking.model.Train;

public class TrainticketbookingSystem {
    static TrainticketbookingSystem trainticketbookingSystem;
    Loginview loginview;

    TrainticketbookingSystem() {
        loginview = new Loginview(this);
    }

    public static TrainticketbookingSystem getInstance() {
        if (trainticketbookingSystem == null)
            trainticketbookingSystem = new TrainticketbookingSystem();
        return trainticketbookingSystem;
    }

    public static void main(String args[]) {
        getInstance().init();
    }

    private void init() {
        loginview.init();
    }
}
