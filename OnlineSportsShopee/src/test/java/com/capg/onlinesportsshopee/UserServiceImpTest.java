package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.service.UserServiceImpl;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is User Service Implementation Test
*/

@SpringBootTest
class UserServiceImpTest {

	@Autowired
	private UserServiceImpl service;

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	List<User> list = new ArrayList<>();

	@Disabled
	@Test
	void testAddUser() {
		User userTemp = new User(1, "Ma", "madhu", "user");
		try {
			service.addUser(userTemp);
			LOGGER.info("AddUser() is Tested");
		} catch (UserServiceException exception) {
			assertEquals("Enter valid user detials", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testAddUser2() {
		User userTemp = new User("madhu13", "user", "Mdhu");
		assertEquals(userTemp.getUsername(), service.addUser(userTemp).getusername());
		LOGGER.info("AddUser2() is Tested");
	}

	@Disabled
	@Test
	void testDeleteUser() throws UserNotFoundException {
		try {
			service.deleteUser(14);
			LOGGER.info("DeleteUser() is Tested");
		} catch (UserServiceException exception) {
			assertEquals("No user found", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testUpdateUser() {
		User userTemp = new User(191, "bhav23", "user", "bhvana");
		userTemp.getUserId();
		assertEquals("bhav23", service.updateUser(userTemp).getusername());
		LOGGER.info("UpdateUser() is Tested");
	}

	@Disabled
	@Test
	void testUpdateUser2() {
		User userTemp = new User(12, "bhavana123", "user", "bhvana");
		userTemp.getUserId();
		try {
			service.updateUser(userTemp);
		} catch (UserServiceException exception) {
			assertEquals("User does not exists ", exception.getMessage());
			LOGGER.info("UpdateUser2() is Tested");
		}

	}


	@Disabled
	@Test
	void testGetUserId() {
		UserDTO user = service.getId(191);
		assertEquals("SyedSamsud", user.getusername());
		LOGGER.info("GetUser() is Tested");
	}

	@Disabled
	@Test
	void testGetUserId2() {
		try {
			service.getId(15);
		} catch (UserServiceException exception) {
			assertEquals("User does not exist", exception.getMessage());
			LOGGER.info("GetUserId2() is Tested");
		}
	}

}