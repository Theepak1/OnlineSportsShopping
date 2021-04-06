
package com.capg.onlinesportsshopee.service;

import java.util.List;

import com.capg.onlinesportsshopee.bean.User;

public interface IUserService {

	public User addUser(User user);

	public User updateUser(User user);

	public String signIn(User user);

	public User signOut(User user);

	public User changePassword(long id, User user);

	public User deleteUser(String userID);

	public User getId(String userID);

	public List<User> getUsers();

	User getId(long userID);

}
=======
package com.capg.onlinesportsshopee.service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;

public interface IUserService {

	public UserDTO addUser(User user);

	public UserDTO updateUser(User user);

	public UserDTO deleteUser(long userId);

	public UserDTO getId(long userId);

	public UserDTO getusername(User user);

}

