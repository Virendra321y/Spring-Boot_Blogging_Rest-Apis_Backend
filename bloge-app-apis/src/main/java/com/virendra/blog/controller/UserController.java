package com.virendra.blog.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virendra.blog.payloads.ApiResponse;
import com.virendra.blog.payloads.UserDto;
import com.virendra.blog.service.UserService;

//import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Post create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	
	
	//Put- Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
		
	  UserDto updatedUser = this.userService.updateUser(userDto, userId);
	  return ResponseEntity.ok(updatedUser);
	  
	}
	
	
	
	//Delete- Delete user
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
//		
//		this.deleteUser(uid);
//		return new ResponseEntity(Map.of("message", "User Delete SuccesFully..."), HttpStatus.OK);
//		
//	}  
	
	//or--> us can create
	@PreAuthorize("hasRole('ADMIN')")//->Esko kewal Admin delete kar sakta hai
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		
		this.userService.deleteUse(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleated SuccesFully", true), HttpStatus.OK);
		
	}
	
	
	
	//Get- user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//Get Single User data
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
