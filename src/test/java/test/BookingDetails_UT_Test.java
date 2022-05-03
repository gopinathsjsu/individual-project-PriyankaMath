package test;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

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

public class BookingDetails_UT_Test {
    @Mock
    private ArrayList<Booking> bookingsMock;
    @InjectMocks
    private BookingDetails bookingDetailsSUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class loadBookingDetails {
        @Test
        public void when_xx_then_success() throws Exception {

            String file = "file";

            boolean addReturnValue = false;
            when(bookingsMock.add((Booking) null)).thenReturn(addReturnValue);

            bookingDetailsSUT.loadBookingDetails(file);

        }
    }
}

