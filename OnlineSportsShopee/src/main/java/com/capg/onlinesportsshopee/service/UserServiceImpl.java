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
	
	private User user;

	@Override
	public UserDTO addUser(User user) throws UserServiceException {
		Optional<User> userTemp = userrepo.findById(user.getUserId());
		if (userTemp.isEmpty() )
		{
			if( validateUserId(user)  && validateUsername(user)  
				&& validatePassword(user))
			{
				user = userrepo.save(user);
				return UserUtil.convertToUserDto(user);
			}
			else
			{
				throw new UserServiceException("Enter the valid user detials");
			}
		
		} 
		else 
		{
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO getId(long userID) {
		Optional<User> getId = userrepo.findById(user.getUserId());
		if (!getId.isEmpty())
		{
			if( validateUserId(user)  && validateUsername(user)  
				&& validatePassword(user))
			{
				User getId1 = userrepo.findById(user.getUserId()).orElse(null);
				return UserUtil.convertToUserDto(getId1);
			}
			else
			{
				throw new UserServiceException("Enter the valid user detials");
			}
		
		} 
		else 
		{
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO updateUser(User user) {
		User updateUser = new User();
		if (updateUser.equals(user))
		{
			if( validateUserId(user)  && validateUsername(user)  
				&& validatePassword(user))
			{
				updateUser = userrepo.save(user);
				return UserUtil.convertToUserDto(updateUser);
			}
			else
			{
				throw new UserServiceException("Enter the valid user detials");
			}
		
		} 
		else 
		{
			throw new UserServiceException("User already exists ");
		}
	}

	@Override
	public UserDTO deleteUser(long userID){
		User usertemp = new User();
		usertemp = userrepo.getOne(userID);
		if(usertemp == null)
			throw new UserServiceException("No user found");
		else
			userrepo.deleteById(userID);	
		return UserUtil.convertToUserDto(usertemp);
	}

	@Override
	public UserDTO getusername(User user) {
		User getusername = new User();
		getusername = userrepo.save(user);
		if (getusername.equals(user))
		{
			if( validateUserId(user)  && validateUsername(user)  
				&& validatePassword(user))
			{
				return UserUtil.convertToUserDto(getusername);
			}
			else
			{
				throw new UserServiceException("Enter the valid user detials");
			}
		
		} 
		else 
		{
			throw new UserServiceException("User already exists ");
		}
	}
	
	public static boolean validateUserId(User user) {
		boolean flag = true;
		Long userId = user.getUserId();
		UserServiceImpl service = new UserServiceImpl();
		if (userId == null|| userId < 0 || !service.userrepo.existsById(userId))
			flag = false;
		return flag;
	}
	
	public static boolean validateUsername(User user) {
		boolean flag = false;
		String userName = user.getUsername();
		if (userName == null||user.getUsername().length() < 3 || user.getUsername().length() > 20) 
			throw new UserServiceException("Invalid Username");
		return flag;
	}
	
	public static boolean validatePassword(User user) {
		boolean flag = false;
		String password = user.getPassword();
		if (password == null||user.getPassword().length() < 3 || user.getPassword().length() > 20) 
			throw new UserServiceException("Password not valid");
		return flag;
	}
	
	public boolean checkUser(long userId,String userName, String password) throws UserNotFoundException {
		boolean flag = false;
		User user = userrepo.findByUserName(userName);
		if(user == null)
			throw new UserNotFoundException("Invalid User Name");
		else if (user.getPassword().equals(password))
			flag = true;
		else 
			throw new UserNotFoundException("Password does not Match");
		return flag;
	}
  
}