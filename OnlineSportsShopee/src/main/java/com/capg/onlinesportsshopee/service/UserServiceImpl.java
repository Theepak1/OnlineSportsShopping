package com.capg.onlinesportsshopee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.repo.IUserRepository;
import com.capg.onlinesportsshopee.util.UserUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepo;


	@Override
	public UserDTO addUser(User user) throws UserServiceException {
		Optional<User> userTemp = userrepo.findById(user.getUserId());
		if (userTemp.isEmpty()) {

			user = userrepo.save(user);
			return UserUtil.convertToUserDto(user);

		} else {
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO getId(long userId) {
		Optional<User> getId = userrepo.findById(userId);
		if (!getId.isEmpty()) {

			User getId1 = userrepo.findById(userId).orElse(null);
			return UserUtil.convertToUserDto(getId1);

		} else {
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO updateUser(User user) {
		User updateUser = new User();
		if (updateUser.equals(user)) {

			updateUser = userrepo.save(user);
			return UserUtil.convertToUserDto(updateUser);

		} else {
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO deleteUser(long userID) {
		User usertemp = new User();
		usertemp = userrepo.getOne(userID);
		if (usertemp == null)
			throw new UserServiceException("No user found");
		else
			userrepo.deleteById(userID);
		return UserUtil.convertToUserDto(usertemp);
	}

	@Override
	public UserDTO getusername(User user) {
		User getusername = new User();
		getusername = userrepo.save(user);
		if (getusername.equals(user)) {

			return UserUtil.convertToUserDto(getusername);

		} else {
			throw new UserServiceException("User already exists ");
		}
	}

	public boolean checkUser(long userId, String username, String password) throws UserNotFoundException {
		boolean flag = false;
		User user = userrepo.findById(userId).orElse(null);
		if (user == null)
			throw new UserNotFoundException("Invalid User Name");
		else if (user.getPassword().equals(password))
			flag = true;
		else
			throw new UserNotFoundException("Password does not Match");
		return flag;
	}

	
}