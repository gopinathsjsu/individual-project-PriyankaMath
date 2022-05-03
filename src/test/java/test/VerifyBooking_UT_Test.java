package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.Flight;
import test.Booking;

import java.io.FileWriter;
import java.lang.Boolean;
import java.io.IOException;

import test.BookingRepository;

import java.util.ArrayList;

import test.FlightRepository;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VerifyBooking_UT_Test {
    @Mock
    private FlightRepository flightDetailsMock;
    @Mock
    private BookingRepository bookingDetailsMock;
    @Mock
    private ArrayList<String> errorsMock;
    @Mock
    private ArrayList<Report> reportsMock;
    @InjectMocks
    private VerifyBooking verifyBookingSUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class loadFlights {
        @Test
        public void when_xx_then_success() throws Exception {
            String file = "C:\\Priyanka\\SJSU\\202\\files\\flights.csv";

            verifyBookingSUT.loadFlights(file);
        }
    }

    @Nested
    public class loadBookings {
        @Test
        public void when_xx_then_success() throws Exception {

            String file = "file";

            verifyBookingSUT.loadBookings(file);

        }
    }

    @Nested
    public class validateBooking {
        @Test
        public void when_xx_then_success() throws Exception {

            ArrayList<Flight> getAllFlightsReturnValue = new ArrayList<Flight>();
            when(flightDetailsMock.getAllFlights()).thenReturn(getAllFlightsReturnValue);


            ArrayList<Booking> getAllBookingsReturnValue = new ArrayList<Booking>();
            when(bookingDetailsMock.getAllBookings()).thenReturn(getAllBookingsReturnValue);


            Boolean isFlightReturnValue = false;
            when(flightDetailsMock.isFlight("booking.flightNumber", "booking.category")).thenReturn(isFlightReturnValue);


            Flight getFlightReturnValue = new Flight();
            when(flightDetailsMock.getFlight("booking.flightNumber", "booking.category")).thenReturn(getFlightReturnValue);

            boolean addReturnValue3 = false;
            when(reportsMock.add((Report) null)).thenReturn(addReturnValue3);

            verifyBookingSUT.validateBooking();

        }
    }

    @Nested
    public class printReport {
        @Test
        public void when_xx_then_success() throws Exception {

            String file = "file";


            verifyBookingSUT.printReport(file);

        }
    }

    @Nested
    public class printErrors {
        @Test
        public void when_xx_then_success() throws Exception {

            String file = "file";

            verifyBookingSUT.printErrors(file);

        }
    }

    @Nested
    public class isCardValid {
        @Test
        public void when_xx_then_success() throws Exception {

            String paymentCardNumber = "paymentCardNumber";


            Boolean isCardValidRetReturnValue = verifyBookingSUT.isCardValid(paymentCardNumber);

            Boolean sutExpected = false;
            assertEquals(sutExpected, isCardValidRetReturnValue);
        }
    }
}

