package com.ticket.app.entity;

import java.math.BigDecimal;
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
@Table(name = "Bookings",schema="otbsystem")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    private Trip trip;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "total_passengers")
    private Integer totalPassengers;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(Integer totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Booking(Long bookingId, User user, Trip trip, LocalDateTime bookingDate, Integer totalPassengers,
			BigDecimal totalAmount) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.trip = trip;
		this.bookingDate = bookingDate;
		this.totalPassengers = totalPassengers;
		this.totalAmount = totalAmount;
	}

	public Booking() {
		super();
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", trip=" + trip + ", totalPassengers="
				+ totalPassengers + "]";
	}

    
    
    
}
