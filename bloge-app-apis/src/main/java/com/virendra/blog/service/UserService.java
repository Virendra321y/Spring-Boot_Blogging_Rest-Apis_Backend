package com.virendra.blog.service;

import java.util.List;

import com.virendra.blog.payloads.UserDto;

public interface UserService {
	
	   UserDto registerNewUser(UserDto user);
	
	   UserDto createUser(UserDto user);   //Data Ko transfore Karne Ke lia ham es UserDto Class Kaa use Kare ge...
	                                       // Jo data User Se lena hoga Ham Esme UserDto ke through lege Ham Wahi Field Lege
	   
	   UserDto updateUser(UserDto user,Integer userId);
	   
	   UserDto getUserById(Integer userId);
	   
	   List<UserDto> getAllUsers();
	   
	   void deleteUse(Integer userId); 

}
