package test;

import java.util.ArrayList;

public class Validator {
    private Validator nextValidator;
    ArrayList<String> errors = new ArrayList<>();
    ArrayList<Report> reports = new ArrayList<>();

    public boolean isValid(FlightRepository flightDetails, Booking booking) {

        if(this.nextValidator != null){
            return this.nextValidator.isValid(flightDetails, booking);
        }
        return false;
    }

    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }
}
