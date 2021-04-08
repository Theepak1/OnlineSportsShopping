package com.capg.onlinesportsshopee.service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;

public interface ILoginService {
	
	public boolean Login(User user) throws LoginNotFoundException, UserNotFoundException;

}