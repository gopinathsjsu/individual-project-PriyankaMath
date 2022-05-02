package test;

public class Booking {
    public String bookingName;
    public String flightNumber;
    public String category;
    public int noOfSeats;
    public String paymentCardNumber;


    public Booking(String bookingName, String flightNumber, String category, int noOfSeats, String paymentCardNumber) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.category = category;
        this.noOfSeats = noOfSeats;
        this.paymentCardNumber = paymentCardNumber;
    }
}
