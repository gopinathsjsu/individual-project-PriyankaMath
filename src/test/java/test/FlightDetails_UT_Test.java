package test;

import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.nio.file.Paths;

import test.Flight;

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

public class FlightDetails_UT_Test {
    @Mock
    private ArrayList<Flight> flightsMock;
    @Mock
    private Flight flightMock;
    @InjectMocks
    private FlightDetails flightDetailsSUT;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class loadFlightsDetails {
        @Test
        public void when_xx_then_success() throws Exception {

            String file = "C:\\Priyanka\\SJSU\\202\\files\\flights.csv";

            boolean addReturnValue = false;
            when(flightsMock.add(new Flight())).thenReturn(addReturnValue);

            flightDetailsSUT.loadFlightsDetails(file);

        }
    }

}

