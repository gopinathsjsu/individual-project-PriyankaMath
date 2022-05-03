package test;

import java.util.ArrayList;

public class ValidFlight extends Validator{
    @Override
    public boolean isValid(FlightRepository flightDetails, Booking booking) {
        var result = flightDetails.isFlight(booking.flightNumber, booking.category);
        if(!result){
            errors.add("Please enter correct booking details for "+booking.bookingName+": invalid flight number\n");
        }
        return super.isValid(flightDetails, booking);
    }
}
