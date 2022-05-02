package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BookingDetails implements BookingRepository{

    ArrayList<Booking> bookings = new ArrayList<>();

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public void loadBookingDetails(String file){
        Path filePath = Paths.get(file);
        try(BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)){
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line != null){
                String[] properties = line.split(",");
                Booking booking = createBooking(properties);
                bookings.add(booking);
                line = bufferedReader.readLine();
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    private static Booking createBooking(String[] properties) {
        String bookingName = properties[0];
        String flightNumber = properties[1];
        String category = properties[2];
        int noOfSeats = Integer.parseInt(properties[3]);
        String paymentCardNumber = properties[4];
        return new Booking(bookingName, flightNumber, category, noOfSeats, paymentCardNumber);
    }
}
