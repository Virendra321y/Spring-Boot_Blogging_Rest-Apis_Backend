package com.virendra.blog.service;

import java.util.List;

import com.virendra.blog.entities.Post;
import com.virendra.blog.payloads.PostDto;
import com.virendra.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deltePost(Integer postId);
	
	//getAllPost
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);
	
	//Get single Post
	
	PostDto getPostById(Integer postId);
	
	//Get All post by Category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//Get All Posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//post search -->Searching of any data 
	List<PostDto> searchPost(String keyword);

}
