package com.capg.onlinesportsshopee.controller;

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
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.service.IUserService;

@RestController
@RequestMapping("/api/oss")
public class UserController {
	
	@Autowired
	private IUserService userservice;

	@PostMapping("/adduser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
		UserDTO resultuser = userservice.addUser(user);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
		UserDTO resultuser = userservice.updateUser(user);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{userID}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable long userID) throws UserServiceException {
		UserDTO resultuser = userservice.deleteUser(userID);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<UserDTO> getId(@PathVariable long id) {
		UserDTO resultuser = userservice.getId(id);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}
	
	@GetMapping("/getuser/{username}")
	public ResponseEntity<UserDTO> getusername(@PathVariable User user) {
		UserDTO resultuser = userservice.getusername(user);
		return new ResponseEntity<UserDTO>(resultuser, HttpStatus.OK);
	}	
	
}