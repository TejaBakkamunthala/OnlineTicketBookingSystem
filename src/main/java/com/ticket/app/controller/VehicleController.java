package com.ticket.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.app.common.Pagination;
import com.ticket.app.entity.Vehicle;
import com.ticket.app.service.VehicleService;

@RestController

public class VehicleController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VehicleService vehicleService;

	@GetMapping(path = "/vehicles")
	public Page<Vehicle> getListOfVehicles(@RequestParam(value = "body", defaultValue = "{}") String body,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "recordPerPage", defaultValue = "100") int recordPerPage,
			@RequestParam(value = "sortKey", defaultValue = "vehicleId") String sortKey,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir)
			throws JsonMappingException, JsonProcessingException {

		logger.info("Entering into getListOfVehicles method");

		System.out.println("Page Number : " + pageNo);
		System.out.println("Record per Number : " + recordPerPage);
		System.out.println("Sort Key : " + sortKey);
		System.out.println("Sort Direction : " + sortDir);

		ObjectMapper vehicleObjectMapper = new ObjectMapper();
		Vehicle searchedVehicleObjectInfo = vehicleObjectMapper.readValue(body, Vehicle.class);

		Pagination pagination = new Pagination(pageNo, recordPerPage, sortDir, sortKey);

		Page<Vehicle> vehicles = vehicleService.getListOfVehicles(searchedVehicleObjectInfo, pagination);

		return vehicles;
	}

	@GetMapping(path = "/vehicles/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
		logger.info("Entering into getVehicleById method");

		try {
			Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
			return ResponseEntity.ok(vehicle);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
