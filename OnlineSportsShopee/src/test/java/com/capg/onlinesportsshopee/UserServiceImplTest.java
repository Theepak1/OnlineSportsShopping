package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());

	List<User> list = new ArrayList<>();

	//@Disabled
	@Test
	void testAddUser() {
		User userTemp = new User(1, "Madhu","madhu","user");
		try {
			service.addUser(userTemp);
			LOGGER.info("AddUser() is Tested");
		} catch (UserServiceException exception) {
			assertEquals("Enter valid user detials", exception.getMessage());
		}

	}

	//@Disabled
	@Test
	void testAddUser2() {
		User userTemp = new User(1,"madhu123","user","Madhu");
		assertEquals(userTemp.getUsername(), service.addUser(userTemp).getusername());
		LOGGER.info("AddUser2() is Tested");
	}

	//@Disabled
	@Test
	void testDeleteUser() throws UserNotFoundException  {
		try {
			service.deleteUser(34);
		} catch (UserNotFoundException exception) {
			assertEquals("No user found", exception.getMessage());
			LOGGER.info("DeleteUser() is Tested");
		}

	}

	//@Disabled
	@Test
	void testUpdateUser() {
		User userTemp = new User(32,"bhav123","user","bhavana");
		userTemp.getUserId();
		assertEquals(32 , service.updateUser(userTemp).getUserId());	
		LOGGER.info("UpdateUser() is Tested");
	}
	
	//@Disabled
	@Test
	void testUpdateUser2() {
		User userTemp = new User(12,"bhavana123","user","bhvana"); //check order of variables 
		userTemp.getUserId();
		try {
		service.updateUser(userTemp);
		}
		catch(UserServiceException exception)
		{
			assertEquals("User does not exist for userId", exception.getMessage());
			LOGGER.info("UpdateUser2() is Tested");
		}
		
	}

	
	  //@Disabled 
	  @Test void testGetUserId(){ 
		  UserDTO user = service.getId(29);
		  assertEquals(29, user.getUserId());
		  LOGGER.info("GetUser() is Tested");
	  }
	 
	//@Disabled
	@Test
	void testGetUserId2()  {
		try {
			service.getId(13);
		}catch (UserServiceException exception) {
			assertEquals("User does not exist for userId", exception.getMessage());
			LOGGER.info("GetUserId2() is Tested");
		}
	}
}

	
