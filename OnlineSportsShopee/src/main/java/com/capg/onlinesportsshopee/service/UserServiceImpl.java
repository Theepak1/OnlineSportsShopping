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

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is User Service Layer that provides services to Add New User, Update Existing User details, 
 *               Delete Existing User, Get Existing User details
*/

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
	public UserDTO getId(long userId) throws UserServiceException {
		Optional<User> getUserTemp = userrepo.findById(userId);
		if (getUserTemp.isEmpty()) {
			throw new UserServiceException("User does not exist");
		} else {
			User getUserId = userrepo.findById(userId).orElse(null);
			return UserUtil.convertToUserDto(getUserId);
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
	
	public boolean validateUserId(long id) throws UserNotFoundException
	{
		boolean flag = userrepo.existsById(id);
		if(flag == false)
			throw new UserNotFoundException("No user found. Enter valid UserId");
		return flag;
	}
	
	public static boolean validateUsername(String userName) throws UserNotFoundException
    {  
		boolean flag = false;
		if(userName == null)
			throw new UserNotFoundException("User Name cannot be empty");
		else if(userName.isEmpty())
			throw new UserNotFoundException("User not found");
		else if(userName.length()<3 || userName.length()>40)
			throw new UserNotFoundException("Invalid User Name");
		else
			flag = true;
		return flag;
    }	
	
	public static boolean validatePassword(String Password) throws UserNotFoundException
    {  
		boolean flag = false;
		if(Password == null)
			throw new UserNotFoundException("Password cannot be null");
		else if(!Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
			throw new UserNotFoundException("Invalid password");
		else
			flag = true;
		return flag;
    }

	public boolean validateUser(User user) throws UserNotFoundException {
		boolean flag = false;
		if(user == null)
			throw new UserNotFoundException("User details cannot be blank");
		else if(!(validateUsername(user.getUsername()) && validatePassword(user.getPassword())))
			throw new UserNotFoundException("Invalid User Details"); 
		else
			flag = true;
		return flag;
	}

}