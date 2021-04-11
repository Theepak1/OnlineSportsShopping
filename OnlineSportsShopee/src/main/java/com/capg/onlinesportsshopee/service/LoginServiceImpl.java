package com.capg.onlinesportsshopee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is Login Service Interface Layer that provides services to Log-in 
*/

@Service
public class LoginServiceImpl implements ILoginService {

	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public boolean Login(User user) throws LoginNotFoundException,UserNotFoundException {
		boolean flag = false;
		if(user == null)
			throw new LoginNotFoundException("User Details cannot be Empty");
		else if(!userService.checkUser(user.getUserId(), user.getUsername(), user.getPassword()))
			throw new LoginNotFoundException("Invalid UserName or Password");
		else
			flag = true;
		return flag;
	}

}