package com.ticket.app.service;

import java.util.List;

import com.ticket.app.entity.Trip;

public interface TripService {
    Trip createTrip(Trip trip);
    Trip getTripById(Long tripId);
    List<Trip> getAllTrips();
    void deleteTrip(Long tripId);
    // Add more methods as needed
}
