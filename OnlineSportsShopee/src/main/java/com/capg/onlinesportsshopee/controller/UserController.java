package com.capg.onlinesportsshopee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.service.IUserService;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is User Controller
*/


@RestController
@RequestMapping("/api/oss")
public class UserController {
	
	@Autowired
	private IUserService userservice;
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());

	@PostMapping("/adduser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
		LOGGER.info("Add User is executed");
		UserDTO resultuser = userservice.addUser(user);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
		LOGGER.info("Update User is executed");
		UserDTO resultuser = userservice.updateUser(user);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable long userId) throws UserNotFoundException {
		LOGGER.info("Delete User executed");
		UserDTO resultuser = userservice.deleteUser(userId);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserDTO> getId(@PathVariable long userId) {
		LOGGER.info("Get User By Id is executed");
		UserDTO resultuser = userservice.getId(userId);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}
	
}