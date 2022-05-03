package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator extends Validator{
    @Override
    public boolean isValid(FlightRepository flightDetails, Booking booking) {
        Flight flight = flightDetails.getFlight(booking.flightNumber, booking.category);
        var totalPrice = flight.calculateTotalPrice(booking.noOfSeats);
        boolean isValid = false;
        String regex = "^(?:(4[0-9]{12}(?:[0-9]{3})?)|" +
                "([1-5]{1}[0-9]{15})|" +
                "(6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(3[47][0-9]{13}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(booking.paymentCardNumber);
        if(matcher.matches()) isValid = true;
        if(!isValid){
            errors.add("Please enter correct booking details for "+booking.bookingName+": Invalid Card\n");
        }
        return super.isValid(flightDetails, booking);
    }
}
