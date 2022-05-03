package test;

public class Report {
    public String bookingName;
    public String flightNumber;
    public String seatCategory;
    public int noOfBookedSeats;
    public float totalPrice;


    public Report(String bookingName, String flightNumber, String seatCategory, int noOfBookedSeats, float totalPrice) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.noOfBookedSeats = noOfBookedSeats;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  bookingName + ',' + flightNumber + ',' + seatCategory + ','+ noOfBookedSeats + ',' + totalPrice + '\n';
    }
}
