package com.ticket.app.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicles",schema="otbsystem")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "mode_id",referencedColumnName = "mode_id")
    private TransportMode mode;

    @ManyToOne
    @JoinColumn(name = "provider_id",referencedColumnName = "provider_id")
    private TransportProvider provider;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "capacity")
    private Integer capacity;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public TransportMode getMode() {
		return mode;
	}

	public void setMode(TransportMode mode) {
		this.mode = mode;
	}

	public TransportProvider getProvider() {
		return provider;
	}

	public void setProvider(TransportProvider provider) {
		this.provider = provider;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Vehicle(Long vehicleId, TransportMode mode, TransportProvider provider, String vehicleName,
			Integer capacity) {
		super();
		this.vehicleId = vehicleId;
		this.mode = mode;
		this.provider = provider;
		this.vehicleName = vehicleName;
		this.capacity = capacity;
	}

	
	public Vehicle() {
		super();
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", mode=" + mode + ", provider=" + provider + ", vehicleName="
				+ vehicleName + ", capacity=" + capacity + "]";
	}

    
}
