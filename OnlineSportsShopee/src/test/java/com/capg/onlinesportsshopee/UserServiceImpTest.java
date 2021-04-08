package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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

	List<User> list = new ArrayList<>();

   //@Disabled
	@Test
	void testAddUser() {
		User userTemp = new User(1, "Madhu", "madhu", "user");
		try {
			service.addUser(userTemp);
		} catch (UserServiceException exception) {
			assertEquals("Enter valid user detials", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testAddUser2() {
		User userTemp = new User(1, "Madhu", "madhu123", "user");
		assertEquals(userTemp.getUsername(), service.addUser(userTemp));
	}

    @Disabled
	@Test
	void testDeleteUser() throws UserNotFoundException {
		try {
			service.deleteUser(14);
		} catch (UserServiceException exception) {
			assertEquals("User does not exist to delete", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testUpdateUser() {
		User userTemp = new User(11, "bhvana", "bhav123", "user");
		userTemp.getUserId();
		assertEquals("pending", service.updateUser(userTemp));
	}

   @Disabled
	@Test
	void testUpdateUser2() {
		User userTemp = new User(12, "bhvana", "bhavana123", "user");
		userTemp.getUserId();
		try {
			service.updateUser(userTemp);
		} catch (UserServiceException exception) {
			assertEquals("User does not exist for UserId", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testGetUserId() {
		UserDTO user = service.getId(9);
		assertEquals("Madhu", user.getusername());
	}

	@Disabled
	@Test
	void testGetUserId2() {
		try {
			service.getId(15);
		} catch (UserServiceException exception) {
			assertEquals("User does not exist for UserId", exception.getMessage());
		}
	}

}