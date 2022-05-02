package test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;


public class VerifyBooking {
    private final FlightRepository flightDetails;
    private final BookingRepository bookingDetails;
    ArrayList<String> errors = new ArrayList<>();
    ArrayList<Report> reports = new ArrayList<>();


    VerifyBooking(FlightRepository flightDetails, BookingRepository bookingDetails) {
        this.flightDetails = flightDetails;
        this.bookingDetails = bookingDetails;
    }

    public void loadFlights(String file){
        this.flightDetails.loadFlightsDetails(file);
    }

    public void loadBookings(String file){
        this.bookingDetails.loadBookingDetails(file);
    }

    public void validateBooking(){
        ArrayList<Flight> flights = flightDetails.getAllFlights();
        ArrayList<Booking> bookings = bookingDetails.getAllBookings();

        for(Booking booking: bookings){
            var result = flightDetails.isFlight(booking.flightNumber, booking.category);
            if(!result){
                errors.add("Please enter correct booking details for "+booking.bookingName+": invalid flight number\n");
                continue;
            }
            Flight flight = flightDetails.getFlight(booking.flightNumber, booking.category);
            var totalPrice = flight.calculateTotalPrice(booking.noOfSeats);
            if(!isCardValid(booking.paymentCardNumber)){
                errors.add("Please enter correct booking details for "+booking.bookingName+": Invalid Card\n");
                continue;
            }
            var isSuccess = flight.modifyAvailableSeats(booking.noOfSeats);
            if(!isSuccess){
                errors.add("Please enter correct booking details for "+booking.bookingName+" :no seats available in "+booking.category+"\n");
            continue;
            }
            Report report = new Report(booking.bookingName, booking.flightNumber, booking.category, booking.noOfSeats, totalPrice);
            reports.add(report);
        }
    }

    public void printReport(String file){
        var reportHeader = "BookingName,FlightNumber,SeatCategory,NoOfSeatsBooked,TotalPrice"+"\n";
        writeIntoFile(file, reports, reportHeader);
    }

    public void printErrors(String file){
        var errorHeader="";
        writeIntoFile(file, errors, errorHeader);
    }

    private static <T> void writeIntoFile(String file, ArrayList<T> reports, String reportHeader) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            if(!reportHeader.isEmpty())
                fileWriter.write(reportHeader);
            for(T report: reports){
                fileWriter.write(report.toString());
            }
            fileWriter.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static Boolean isCardValid(String paymentCardNumber) {
        boolean isValid = false;
        String regex = "^(?:(4[0-9]{12}(?:[0-9]{3})?)|" +
                "([1-5]{1}[0-9]{15})|" +
                "(6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(3[47][0-9]{13}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(paymentCardNumber);
        if(matcher.matches()) isValid = true;
        return isValid;
    }
}
