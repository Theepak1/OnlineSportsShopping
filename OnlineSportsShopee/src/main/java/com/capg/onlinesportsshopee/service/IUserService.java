
package com.capg.onlinesportsshopee.service;


import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.model.UserDTO;

public interface IUserService {

	public UserDTO addUser(User user);

	public UserDTO updateUser(User user);

	public UserDTO deleteUser(long userId) throws UserNotFoundException;

	public UserDTO getId(long userId);


	public UserDTO getusername(User user);

}




