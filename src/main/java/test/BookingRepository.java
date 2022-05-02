package test;

import java.util.ArrayList;

public interface BookingRepository {
    ArrayList<Booking> getAllBookings();
    void loadBookingDetails(String arg);
}
