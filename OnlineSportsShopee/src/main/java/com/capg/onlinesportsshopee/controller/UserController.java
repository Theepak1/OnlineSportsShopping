package com.capg.onlinesportsshopee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.InvalidUsernamePasswordException;
import com.capg.onlinesportsshopee.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private IUserService userservice;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}

	@GetMapping("/{id}")
	
	public User addUser(@PathVariable String id) {
		return userservice.getId(id);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}

	@DeleteMapping("/{userID}")
	public User deleteUser(@PathVariable String userID) {
		return userservice.deleteUser(userID);
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable String userId) {
		return userservice.getId(userId);
	}

	@GetMapping(value="/login")
	public String userLogin(@RequestBody User user) throws InvalidUsernamePasswordException {
		try {
			return userservice.signIn(user);
		} catch (Exception e) {
			 throw new InvalidUsernamePasswordException("Inalid Password/Username");
		}
		
	}

	@GetMapping
	public User userLogout(@PathVariable("username") int username, @PathVariable("password") String password)  {
		
		return userservice.signOut(null);
	}
	
	@GetMapping(value="/all")
	public List<User> getAllUsers(){
		return userservice.getUsers();
	}
}
