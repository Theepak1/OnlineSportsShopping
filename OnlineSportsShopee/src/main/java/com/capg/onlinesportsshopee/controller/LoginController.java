package com.capg.onlinesportsshopee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.service.ILoginService;



@RestController
@RequestMapping("/api/oss")
public class LoginController {
	

		@Autowired
		private ILoginService loginService;
		
		@PatchMapping("/validatelogin")
		public ResponseEntity<String> validateLogin(@RequestBody User user) throws LoginNotFoundException,UserNotFoundException
		{
			ResponseEntity<String> loginResponse = new ResponseEntity<String>("User Id and Password Does Not Match", HttpStatus.ACCEPTED);
			if(!loginService.Login(user))
				throw new LoginNotFoundException("Login id  and Password Does not match");
			else
				loginResponse = new ResponseEntity<String>("Login Successful!", HttpStatus.ACCEPTED);
			return loginResponse;
		}
		
}
