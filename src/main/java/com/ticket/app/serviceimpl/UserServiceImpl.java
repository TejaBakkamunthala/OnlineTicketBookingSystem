package com.ticket.app.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.app.common.Pagination;
import com.ticket.app.entity.User;
import com.ticket.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	public Page<User> getListOfUsers(User searchedUserObjectInfo, Pagination pagination) {
		logger.info("Entering into getListOfUsers method");
		Page<User> listOfUsersToBeReturned = userRepository.findAll(searchCriteriaForUser(searchedUserObjectInfo),
				pagination.getPageableInstance());
		return listOfUsersToBeReturned;
	}

	public Specification<User> searchCriteriaForUser(User userObject) {
		logger.info("Entering into searchCriteriaForUser method");
		return userObject!=null? Specification.where(userObject.getUserName() != null ? containsUserName(userObject.getUserName()) : null)
				.and(userObject.getUserId() > 0 ? containsUserId(userObject.getUserId()) : null)
				.and(userObject.getEmail() != null ? containsEmail(userObject.getEmail()) : null)
				.and(userObject.getPhoneNumber() != null ? containsPhoneNumber(userObject.getPhoneNumber()) : null):null;
	}

	private Specification<User> containsUserName(String userName) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(user.get("userName"), userName);
	}

	private Specification<User> containsUserId(long userId) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(user.get("userId"), userId);
	}

	private Specification<User> containsEmail(String email) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(user.get("email"), email);
	}

	private Specification<User> containsPhoneNumber(String phoneNumber) {
		return (user, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(user.get("phoneNumber"),
				"%" + phoneNumber + "%");
	}

	@Transactional
	public User UpdateUser(User user) {
		logger.info("Entering into saveOrUpdateUser method");
		return userRepository.saveAndFlush(user);
	}

	@Transactional
	public User save(User user) {
		logger.info("Entering into saveOrUpdateUser method");
		return userRepository.saveAndFlush(user);
	}

	public User getUserById(long userId) throws Exception {
		logger.info("Entering into getUserById method");
		return userRepository.findById(userId)
				.orElseThrow(() -> new Exception("User for userId = " + userId + " not found"));
	}

	public void deleteUserById(long userId) throws Exception {
		logger.info("Entering into deleteUserById method");

		if (!userRepository.existsById(userId)) {
			throw new Exception("User for userId = " + userId + " not found");
		}

		userRepository.deleteById(userId);
	}

}