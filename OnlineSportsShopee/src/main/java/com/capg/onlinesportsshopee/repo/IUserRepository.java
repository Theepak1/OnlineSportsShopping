
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
=======
package com.capg.onlinesportsshopee.repo;

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

