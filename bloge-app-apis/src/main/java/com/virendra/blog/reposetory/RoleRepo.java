package com.virendra.blog.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virendra.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
