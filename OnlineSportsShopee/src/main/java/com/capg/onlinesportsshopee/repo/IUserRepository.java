
package com.capg.onlinesportsshopee.repo;

import java.util.List;


import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
	
	
	
	/*
	 * public User addUser(User user); public User getId(long userID); public User
	 * updateUser(User user); public User deleteUser(long userID); public UserDTO
	 * getusername(User user);
	 */
	
}

