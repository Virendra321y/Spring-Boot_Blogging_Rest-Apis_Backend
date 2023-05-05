package com.virendra.blog.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virendra.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
