package com.ticket.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trips",schema="otbsystem")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "route_id",referencedColumnName = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "available_seats")
    private Integer availableSeats;

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Trip(Long tripId, Route route, Vehicle vehicle, LocalDateTime departureTime, LocalDateTime arrivalTime,
			Integer availableSeats) {
		super();
		this.tripId = tripId;
		this.route = route;
		this.vehicle = vehicle;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
	}

	public Trip() {
		super();
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", route=" + route + ", vehicle=" + vehicle + ", availableSeats="
				+ availableSeats + "]";
	}

  
}
