package com.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElse(null);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = getBookingById(id);
        booking.setPassengerName(bookingDetails.getPassengerName());
        booking.setPickupLocation(bookingDetails.getPickupLocation());
        booking.setDropLocation(bookingDetails.getDropLocation());
//        booking.setBookingTime(bookingDetails.getBookingTime());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
