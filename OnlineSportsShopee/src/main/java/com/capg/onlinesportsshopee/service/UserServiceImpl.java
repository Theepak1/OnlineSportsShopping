package com.capg.onlinesportsshopee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.repo.IUserRepository;
import com.capg.onlinesportsshopee.util.UserUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userrepo;

	@Override
	public UserDTO addUser(User user) {
		User addUser = new User();
		addUser = userrepo.save(user);
		return UserUtil.convertToUserDto(addUser);
	}

	@Override
	public UserDTO getId(long userID) {
		User getId = new User();
		getId = userrepo.findById(userID).orElse(null);
		return UserUtil.convertToUserDto(getId);
	}

	@Override
	public UserDTO updateUser(User user) {
		User updateUser = new User();
		updateUser = userrepo.save(user);
		return UserUtil.convertToUserDto(updateUser);
	}

	@Override
	public UserDTO deleteUser(long userID) {
		User usertemp = new User();
		usertemp = userrepo.getOne(userID);
		userrepo.deleteById(userID);
		return UserUtil.convertToUserDto(usertemp);
	}

	@Override
	public UserDTO getusername(User user) {
		User getusername = new User();
		getusername = userrepo.save(user);
		return UserUtil.convertToUserDto(getusername);

	}
	
	public static boolean validateUserId(User user) {
		boolean flag = true;
		Long userId = user.getUserId();
		UserServiceImpl service = new UserServiceImpl();
		if (userId == null|| userId < 0 || !service.userrepo.existsById(userId))
			flag = false;
		return flag;
	}
	
	public static void validateUsername(User user) {
		String userName = user.getUsername();
		if (userName == null||user.getUsername().length() < 3 || user.getUsername().length() > 20) 
			throw new UserServiceException("Invalid Username");
	}
	
	public static void validatePassword(User user) {
		String password = user.getPassword();
		if (password == null||user.getPassword().length() < 3 || user.getPassword().length() > 20) 
			throw new UserServiceException("Password not valid");
	}
  
}