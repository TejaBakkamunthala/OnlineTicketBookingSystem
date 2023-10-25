package com.ticket.app.service;


import org.springframework.data.domain.Page;

import com.ticket.app.common.Pagination;
import com.ticket.app.entity.Vehicle;

public interface VehicleService {

	Page<Vehicle> getListOfVehicles(Vehicle searchedVehicleObjectInfo, Pagination pagination);
	Vehicle getVehicleById(Long vehicleId) throws Exception;
	
	
}
