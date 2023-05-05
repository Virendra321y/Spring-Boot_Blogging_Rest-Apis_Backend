package com.virendra.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.virendra.blog.reposetory.UserRepo;

@SpringBootTest
class BlogeAppApisApplicationTests {
	
	@Autowired
	private UserRepo userRepo;
	

	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void repoTest() {
		
		String className = this.userRepo.getClass().getName();
		String packname = this.userRepo.getClass().getPackageName();
		System.out.println("this data--->"+className);
		System.out.println("second data-->"+packname);
	}

}
