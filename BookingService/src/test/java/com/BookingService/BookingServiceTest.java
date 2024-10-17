package com.BookingService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback 
class BookingServiceTest {

    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
    }

    @Test
    void testCreateBooking() {
        Booking booking = new Booking();
        booking.setPassengerName("John Doe");
        booking.setPickupLocation("Airport");
        booking.setDropLocation("Hotel");
        booking.setBookingTime("2024-10-14T10:00:00");

        Booking createdBooking = bookingService.createBooking(booking);
        assertNotNull(createdBooking);
        assertEquals("John Doe", createdBooking.getPassengerName());
    }

    @Test
    void testGetAllBookings() {
        bookingService.createBooking(new Booking());
        List<Booking> bookings = bookingService.getAllBookings();
        assertEquals(1, bookings.size());
    }

    @Test
    void testGetBookingById() {
        Booking booking = new Booking();
        booking.setPassengerName("John Doe");
        bookingService.createBooking(booking);

        Booking foundBooking = bookingService.getBookingById(1L);
        assertNotNull(foundBooking);
        assertEquals("John Doe", foundBooking.getPassengerName());
    }
}
