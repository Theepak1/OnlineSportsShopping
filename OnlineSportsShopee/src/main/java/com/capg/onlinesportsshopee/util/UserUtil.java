package com.capg.onlinesportsshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;

public class UserUtil {
	
	public static List<UserDTO> convertToUserDtoList(List<User> list)
	{
		List<UserDTO> UserDTOList = new ArrayList<UserDTO>();
		for (User user : list)
			UserDTOList.add(convertToUserDto(user));
		return UserDTOList;
	}
	
	public static User convertToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserId(userDTO.getUserId());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		
		return user;
	}

	private static UserDTO convertToUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(userDTO.getUserId());
		userDTO.setPassword(userDTO.getPassword());
		userDTO.setRole(userDTO.getRole());
		
		return userDTO;
	}

}
