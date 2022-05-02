package test;

import java.util.ArrayList;

public interface FlightRepository {
    Flight getFlight(String flightNumber, String category);
    Boolean isFlight(String flightNumber, String category);
    ArrayList<Flight> getAllFlights();
    void loadFlightsDetails(String arg);
}
