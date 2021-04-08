package com.capg.onlinesportsshopee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.repo.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	@Autowired
	UserServiceImpl userService;

	public boolean Login(User user) throws UserServiceException, LoginNotFoundException {
		boolean flag = false;
		if(user == null)
			throw new LoginNotFoundException("User Details cannot be Empty");
		else if(!user.equals(user))
			flag = true;
		else
			throw new LoginNotFoundException("Invalid UserName or Password");
		return flag;
	}

}