package com.virendra.blog.reposetory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virendra.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}
