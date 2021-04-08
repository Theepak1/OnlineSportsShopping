package com.capg.onlinesportsshopee.service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.model.UserDTO;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is User Service Interface Layer that provides Interface services to Add New User, Update Existing User details, 
 *               Delete Existing User details, Get Existing User details 
*/

public interface IUserService {

	public UserDTO addUser(User user);

	public UserDTO updateUser(User user);
	
	public UserDTO deleteUser(long userId) throws UserNotFoundException;

	public UserDTO getId(long userId);

}