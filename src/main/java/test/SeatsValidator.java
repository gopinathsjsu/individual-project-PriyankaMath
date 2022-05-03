package test;

public class SeatsValidator extends Validator{
    @Override
    public boolean isValid(FlightRepository flightDetails, Booking booking) {
        Flight flight = flightDetails.getFlight(booking.flightNumber, booking.category);
        var totalPrice = flight.calculateTotalPrice(booking.noOfSeats);
        var isSuccess = flight.modifyAvailableSeats(booking.noOfSeats);
        if(!isSuccess){
            errors.add("Please enter correct booking details for "+booking.bookingName+" :no seats available in "+booking.category+"\n");
        }
        Report report = new Report(booking.bookingName, booking.flightNumber, booking.category, booking.noOfSeats, totalPrice);
        reports.add(report);
        return super.isValid(flightDetails, booking);
    }
}
