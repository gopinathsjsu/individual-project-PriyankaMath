package test;

public class Flight {

    public String category;
    public String flightNumber;
    public int availableSeats;
    public float costOfSeat;
    public String arrivalCity;
    public String departureCity;


    public Flight() {
    }

    public Flight(String category, String flightNumber, int availableSeats, float costOfSeat, String arrivalCity, String departureCity) {
        this.category = category;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.costOfSeat = costOfSeat;
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
    }

    public float calculateTotalPrice(int noOfBookedSeats){
        return noOfBookedSeats*costOfSeat;
    }

    public Boolean modifyAvailableSeats(int noOfBookingSeats){
        if(availableSeats==0 || noOfBookingSeats > availableSeats) return false;
        this.availableSeats = this.availableSeats - noOfBookingSeats;
        return true;
    }

}
