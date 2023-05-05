package com.virendra.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.virendra.blog.entities.Role;

import ch.qos.logback.core.joran.spi.NoAutoStart;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "User character must be mean of 4 characters")
	private String name;
	
	@Email(message = "Email addres is not vallid!!")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 10,message = "Password must be min of 3 charactor and max of 10 charactor !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
	
	

}
