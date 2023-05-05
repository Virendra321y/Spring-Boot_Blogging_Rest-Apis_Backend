package com.virendra.blog.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virendra.blog.entities.Category;
import com.virendra.blog.entities.Post;
import com.virendra.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);              //this is custom finder method which provide all information
	List<Post> findByCategory(Category category);//-->this method provide data by Category
	
	@Query("select p from Post p where p.title like :key")//this is native like Quary to get gata fromdatabsae
	List<Post> searchByTitle(@Param("key") String title);  //-->this method proved Seachig concept

}
