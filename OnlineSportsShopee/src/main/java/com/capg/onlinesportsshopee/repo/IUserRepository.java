package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;


@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

	
	
	public UserDTO findByUsername(String username);


	
	
	
	/*
	 * public User addUser(User user); public User getId(long userID); public User
	 * updateUser(User user); public User deleteUser(long userID); public UserDTO
	 * getusername(User user);
	 */
	
}