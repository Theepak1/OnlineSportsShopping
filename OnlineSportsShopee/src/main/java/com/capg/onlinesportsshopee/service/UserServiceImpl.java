package com.capg.onlinesportsshopee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserServiceException;
import com.capg.onlinesportsshopee.repo.IUserRepository;

@Transactional
@Service
public abstract class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repository;

	@Override
	public User addUser(User user) {
		repository.save(user);
		return user;
	}

	@Override
	public User getId(long userID) {
		User user =null;
		try {
			user= (User) ((IUserRepository) repository.findById(userID)).get();
		} catch (Exception e) {
			throw new UserServiceException("User with ID: "+userID+" not found!");
		}
		
		return user;
	}

	@Override
	public User updateUser(User user) {
		try {
			getId(user.getUserId());
			repository.saveAndFlush(user);
		} catch (Exception e) {
			 throw new UserServiceException("User Can not be updated!");
		}
		
		return user;
	}


	@Override
	public User deleteUser(String userID) throws UserServiceException {
		 User u = null;
		try {
			u = getId(userID);
			repository.deleteById(userID);
		} catch (Exception e) {
			throw new UserServiceException("User Not Fund To Delete!");
		}
		
		return u;
	}

	@Override
	public String signIn(User user) {

		return repository.signIn(user) ;
	}

	@Override
	public User signOut(User user) {
		 
		return null;
	}

	@Override
	public User changePassword(long id, User user) {
		User u = (User) ((IUserRepository) repository.findById(user.getUserId())).get();
		u.setPassword(user.getPassword());
		return u;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
