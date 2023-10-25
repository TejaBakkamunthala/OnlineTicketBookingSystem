package com.ticket.app.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.app.common.Pagination;
import com.ticket.app.entity.Vehicle;
import com.ticket.app.repository.VehicleRepository;
import com.ticket.app.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Page<Vehicle> getListOfVehicles(Vehicle searchedVehicleObjectInfo, Pagination pagination) {
		logger.info("Entering into getListOfVehicles method");

		Page<Vehicle> listOfVehiclesToBeReturned = vehicleRepository.findAll(searchCriteriaForVehicle(searchedVehicleObjectInfo), pagination.getPageableInstance());
		return listOfVehiclesToBeReturned;
	}

	
	public Specification<Vehicle> searchCriteriaForVehicle(Vehicle vehicleObject) {
		logger.info("Entering into searchCriteriaForVehicle method");
		return vehicleObject != null ? Specification
				.where(vehicleObject.getVehicleName() != null ? containsVehicleName(vehicleObject.getVehicleName())
						: null)
				.and(vehicleObject.getCapacity() != null ? containsCapacity(vehicleObject.getCapacity()) : null) 
				         : null;
	}

	private Specification<Vehicle> containsVehicleName(String vehicleName) {
		return (vehicle, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(vehicle.get("vehicleName"), vehicleName);
		};
	}

	private Specification<Vehicle> containsCapacity(Integer capacity) {
		return (vehicle, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(vehicle.get("capacity"), capacity);
		};
	}

	
	
	

	@Transactional
	public Vehicle saveOrUpdateVehicle(Vehicle vehicle) {
		logger.info("Entering into saveOrUpdateVehicle method");
		return vehicleRepository.saveAndFlush(vehicle);
	}

	@Override
	public Vehicle getVehicleById(Long vehicleId) {
		logger.info("Entering into getVehicleById method");

		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

		return optionalVehicle.get();
	}

}
