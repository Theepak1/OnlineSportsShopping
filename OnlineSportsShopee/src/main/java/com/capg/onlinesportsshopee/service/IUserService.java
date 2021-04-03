package com.capg.onlinesportsshopee.service;

import com.capg.onlinesportsshopee.bean.User;

public interface IUserService {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
}
