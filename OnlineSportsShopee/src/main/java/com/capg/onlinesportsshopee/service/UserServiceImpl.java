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
 *               Delete Existing User, Get Existing User details and Check User
*/


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepo;
	
	/*
	 * Description : This method adds User
	 * Input Parameter : User Object 
	 * Return Value : UserDTO Object 
	 * Exception : UserServiceException
	 */

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
	
	/*
	 * Description : This method Updates User Details
	 * Input Parameter : User Object 
	 * Return Value : UserDTO Object 
	 * Exception : UserServiceException
	 */

	
	@Override
	public UserDTO updateUser(User user) throws UserServiceException {
		Optional<User> user1 = userrepo.findById(user.getUserId());
		if (!user1.isEmpty()) {

			User updateUser = userrepo.save(user);
			return UserUtil.convertToUserDto(updateUser);

		} else {
			throw new UserServiceException("User already exists ");
		}
	}
	
	/*
	 * Description : This method deletes User
	 * Input Parameter : User Object 
	 * Return Value : UserDTO Object 
	 * Exception : UserNotFoundException
	 */


	@Override
	public UserDTO deleteUser(long userId) throws UserNotFoundException {
		Optional<User> user1 = userrepo.findById(userId);
		if (user1.isEmpty())
			throw new UserServiceException("No user found");
		else {
			userrepo.deleteById(userId);
			if(user1.isPresent())
			{
				return UserUtil.convertToUserDto(user1.get());
			}
			else
			{
				throw new UserNotFoundException("User is not present ");
			}
		}	
	}
	
	/*
	 * Description : This method gets User by userID
	 * Input Parameter : User Object 
	 * Return Value : UserDTO Object 
	 * Exception : UserServiceException
	 */
	
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
	
	/*
	 * Description : This method checks User
	 * Input Parameter : User Object 
	 * Return Value : UserDTO Object 
	 * Exception : UserNotFoundException
	 */

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
	
	/*
	 * Description : This method validate UserID
	 * Input Parameter :  User Object
	 * Return Value : boolean 
	 * Exception : UserNotFoundException
	 */
	
	public boolean validateUserId(long id) throws UserNotFoundException
	{
		boolean flag = userrepo.existsById(id);
		if(flag == false)
			throw new UserNotFoundException("No user found. Enter valid UserId");
		return flag;
	}
	
	/*
	 * Description : This method validate Username
	 * Input Parameter :  User Object
	 * Return Value : boolean 
	 * Exception : UserNotFoundException
	 */
	
	public static boolean validateUsername(String username) throws UserNotFoundException
    {  
		boolean flag = false;
		if(username == null)
			throw new UserNotFoundException("User Name cannot be empty");
		else if(!username.matches("^[a-zA-Z]+$"))
			throw new UserNotFoundException("Enter valid Username");
		else if(username.length()<3 || username.length()>40)
			throw new UserNotFoundException("Invalid Username");
		else
			flag = true;
		return flag;
    }	
	
	/*
	 * Description : This method validate Password
	 * Input Parameter :  User Object
	 * Return Value : boolean 
	 * Exception : UserNotFoundException
	 */
	
	public static boolean validatePassword(String Password) throws UserNotFoundException
    {  
		boolean flag = false;
		if(Password == null)
			throw new UserNotFoundException("Password cannot be empty");
		else if(!Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
			throw new UserNotFoundException("Invalid password format");
		else
			flag = true;
		return flag;
    }
	
	/*
	 * Description : This method validate User Role
	 * Input Parameter :  User Object
	 * Return Value : boolean 
	 * Exception : Exception
	 */
	
	public static boolean validateRole(User user) throws Exception {
		boolean flag = false;
		if(user.getRole() != "user" || user.getRole() != "admin")
			throw new Exception("Role can only be User or Role");
		else
			flag = true;
		return flag;		
	}
}