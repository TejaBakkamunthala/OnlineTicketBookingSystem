package com.ticket.app.controller;

import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.app.common.Pagination;
import com.ticket.app.entity.User;
import com.ticket.app.repository.UserRepository;
import com.ticket.app.serviceimpl.UserServiceImpl;

@RestController
public class UserController {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserServiceImpl userServiceImpl;

	private UserRepository userRepository;

	@GetMapping(path = "/users")
	public Page<User> getListOfUsers(@RequestParam(value = "body", defaultValue = "{}") String body,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "recordPerPage", defaultValue = "100") int recordPerPage,
			@RequestParam(value = "sortKey", defaultValue = "userId") String sortKey,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir)
			throws JsonMappingException, JsonProcessingException {

		logger.info("Entering into getListOfUsers method");

		System.out.println("Page Number : " + pageNo);
		System.out.println("Record per Number : " + recordPerPage);
		System.out.println("Sort Key : " + sortKey);
		System.out.println("Sort Direction : " + sortDir);

		ObjectMapper userObjectMapper = new ObjectMapper();

		User searchedUserObjectInfo = userObjectMapper.readValue(body, User.class);

		Pagination pagination = new Pagination(pageNo, recordPerPage, sortDir, sortKey);

		Page<User> users = userServiceImpl.getListOfUsers(searchedUserObjectInfo, pagination);

		return users;
	}

	
	
	
	
	
	@GetMapping(path = "/users/{userId}")
	public User getUserById(@PathVariable Long userId) throws Exception {
		logger.info("Entering into getUserById method");
		return userServiceImpl.getUserById(userId);
	}


	@PostMapping(path = "/users")
	public User saveUser(@RequestBody User user) {
		logger.info("Entering into saveUser method");
		User savedUser = userServiceImpl.save(user);

		return savedUser;
	}

	@DeleteMapping(path = "/users/{userId}")
	public void deleteUser(@PathVariable Long userId) throws Exception {
		logger.info("Entering into deleteUser method");
		userServiceImpl.deleteUserById(userId);
	}



}
