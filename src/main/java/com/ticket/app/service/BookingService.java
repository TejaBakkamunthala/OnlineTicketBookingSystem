package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.Booking;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getAllBookings();
    void deleteBooking(Long bookingId);
    // Add more methods as needed
}
