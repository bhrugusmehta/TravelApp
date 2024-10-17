package com.PassengerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback
class PassengerServiceTest {

    private PassengerService passengerService;

    @BeforeEach
    void setUp() {
        passengerService = new PassengerService();
    }

    @Test
    void testCreatePassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("John Doe");
        passenger.setPhone("1234567890");
        passenger.setEmail("John@example.com");

        Passenger createdPassenger = passengerService.createPassenger(passenger);
        assertNotNull(createdPassenger);
        assertEquals("John Doe", createdPassenger.getName());
    }

    @Test
    void testGetAllPassengers() {
        passengerService.createPassenger(new Passenger());
        List<Passenger> passengers = passengerService.getAllPassengers();
        assertEquals(1, passengers.size());
    }

    @Test
    void testGetPassengerById() {
        Passenger passenger = new Passenger();
        passenger.setName("John Doe");
        passengerService.createPassenger(passenger);

        Passenger foundPassenger = passengerService.getPassengerById(1L);
        assertNotNull(foundPassenger);
        assertEquals("John Doe", foundPassenger.getName());
    }
}
