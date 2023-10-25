package com.ticket.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.app.common.Pagination;
import com.ticket.app.entity.TransportMode;
import com.ticket.app.service.TransportModeService;

	@RestController
	public class TransportModeController {
	    private Logger logger = LoggerFactory.getLogger(this.getClass());

	    @Autowired
	    private TransportModeService transportModeService;

	    @GetMapping(path = "/transportmodes")
	    public Page<TransportMode> getListOfTransportModes(
	            @RequestParam(value = "body", defaultValue = "{}") String body,
	            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
	            @RequestParam(value = "recordPerPage", defaultValue = "100") int recordPerPage,
	            @RequestParam(value = "sortKey", defaultValue = "modeId") String sortKey,
	            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir)
	            throws JsonMappingException, JsonProcessingException {

	        logger.info("Entering into getListOfTransportModes method");

	        System.out.println("Page Number : " + pageNo);
	        System.out.println("Record per Number : " + recordPerPage);
	        System.out.println("Sort Key : " + sortKey);
	        System.out.println("Sort Direction : " + sortDir);

	        ObjectMapper objectMapper = new ObjectMapper();
	        TransportMode searchedTransportMode = objectMapper.readValue(body, TransportMode.class);

	        Pagination pagination = new Pagination(pageNo, recordPerPage, sortDir, sortKey);

	        Page<TransportMode> transportModes = transportModeService.getListOfTransportModes(searchedTransportMode, pagination);

	        return transportModes;
	    }

	    @GetMapping(path = "/transportmodes/{modeId}")
	    public TransportMode getTransportModeById(@PathVariable Long modeId) throws Exception {
	        logger.info("Entering into getTransportModeById method");
	        return transportModeService.getTransportModeById(modeId);
	    }
	
}
