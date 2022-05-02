package test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunClient {

	public static void main(String[] args) {
		FlightDetails flightDetails = new FlightDetails();
		BookingDetails bookingDetails = new BookingDetails();
		VerifyBooking verifyBooking = new VerifyBooking(flightDetails, bookingDetails);
		verifyBooking.loadBookings(args[0]);
		verifyBooking.loadFlights(args[1]);
		verifyBooking.validateBooking();
		verifyBooking.printReport(args[2]);
		verifyBooking.printErrors(args[3]);
	}

}
