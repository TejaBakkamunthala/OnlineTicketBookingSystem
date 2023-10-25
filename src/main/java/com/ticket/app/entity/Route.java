package com.ticket.app.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes",schema="otbsystem")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="route_id")
    private int routeId;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "distance")
    private BigDecimal distance;

    @Column(name = "duration")
    private Integer duration;  // Store duration in minutes

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Route(int routeId, String origin, String destination, BigDecimal distance, Integer duration) {
		super();
		this.routeId = routeId;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	public Route() {
		super();
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", origin=" + origin + ", destination=" + destination + ", distance="
				+ distance + ", duration=" + duration + "]";
	}


    
    
}