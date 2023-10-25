package com.ticket.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.app.entity.Trip;
import com.ticket.app.repository.TripRepository;
import com.ticket.app.service.TripService;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTripById(Long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    // Add more methods as needed
}
