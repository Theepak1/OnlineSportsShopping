package com.capg.onlinesportsshopee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;
import com.capg.onlinesportsshopee.repo.IUserRepository;
import com.capg.onlinesportsshopee.util.UserUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userrepo;

	@Override
	public UserDTO addUser(User user) {
		User addUser=new User();
		addUser= userrepo.save(user);
		return UserUtil.convertToUserDto(addUser);
	}


	@Override
	public UserDTO getId(long userID) {
		User getId=new User();
		getId = userrepo.findById(userID).orElse(null);
		return UserUtil.convertToUserDto(getId);
	}

	@Override
	public UserDTO updateUser(User user) {
		User updateUser=new User();
		updateUser=userrepo.save(user);
		return UserUtil.convertToUserDto(updateUser);
	}

	@Override
	public UserDTO deleteUser(long userID){
		User usertemp=new User();
		usertemp=userrepo.getOne(userID);
		userrepo.deleteById(userID);
		return UserUtil.convertToUserDto(usertemp);
	}


	@Override
	public UserDTO getusername(User user) {
		User getusername=new User();
		getusername = userrepo.save(user);
		return UserUtil.convertToUserDto(getusername);

	}

	
}