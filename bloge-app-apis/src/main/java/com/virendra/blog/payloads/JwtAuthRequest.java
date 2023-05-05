package com.virendra.blog.payloads;

import lombok.Data;

@Data //->eske through hamko getter Setter mil jaye ga lomboke ka concept se hota hai
public class JwtAuthRequest {
	
	private String username;
	
	private String password;

}
