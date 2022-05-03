package test;

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

public class Flight_UT_Test {
    @InjectMocks
    private Flight flightSUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class calculateTotalPrice {
        @Test
        public void when_xx_then_success() throws Exception {

            int noOfBookedSeats = 1;

            float calculateTotalPriceRetReturnValue = flightSUT.calculateTotalPrice(noOfBookedSeats);

            float sutExpected = 0.0F;
            assertEquals(sutExpected, calculateTotalPriceRetReturnValue);
        }
    }

    @Nested
    public class modifyAvailableSeats {
        @Test
        public void when_xx_then_success() throws Exception {

            int noOfBookingSeats = 1;

            Boolean modifyAvailableSeatsRetReturnValue = flightSUT.modifyAvailableSeats(noOfBookingSeats);

            Boolean sutExpected = false;
            assertEquals(sutExpected, modifyAvailableSeatsRetReturnValue);
        }
    }
}

