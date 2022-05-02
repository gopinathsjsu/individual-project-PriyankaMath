package test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class FlightDetails implements FlightRepository{
    ArrayList<Flight> flights = new ArrayList<>();
    Flight flight;

    @Override
    public void loadFlightsDetails(String file){
        Path filePath = Paths.get(file);
        try(BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)){
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line != null){
                String[] properties = line.split(",");
                Flight flight = createFlight(properties);
                flights.add(flight);
                line = bufferedReader.readLine();
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    private static Flight createFlight(String[] properties) {
        String category = properties[0];
        String flightNumber = properties[1];
        int availableSeats = Integer.parseInt(properties[2]);
        float costOfSeat = Float.parseFloat(properties[3]);
        String arrivalCity = properties[4];
        String departureCity = properties[5];
        return new Flight(category, flightNumber, availableSeats, costOfSeat, arrivalCity, departureCity);
    }

    @Override
    public Flight getFlight(String flightNumber, String  category){
        for(Flight currentFlight: flights){
            if(currentFlight.flightNumber.equals(flightNumber) && currentFlight.category.equals(category)){
                flight = currentFlight;
                return flight;
            }
        }
        return flight;
    }

    @Override
    public Boolean isFlight(String flightNumber, String category){
        for(Flight flight: flights){
            if(flight.flightNumber.equals(flightNumber) && flight.category.equals(category)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Flight> getAllFlights(){
        return flights;
    }

}
