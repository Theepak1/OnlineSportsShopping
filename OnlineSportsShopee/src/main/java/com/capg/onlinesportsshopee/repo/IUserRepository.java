package com.capg.onlinesportsshopee.repo;

import java.util.List;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;

public interface IUserRepository {
	public String signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
	public List<User> findAll();
	public Object findById(long userId);
	public void deleteById(String userID);
	public void save(User user);
	public List<UserDTO> get();
	public void saveAndFlush(User user);
}
