package com.virendra.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virendra.blog.payloads.CategoryDto;


public interface CategoryService {
	
	//Create 
	CategoryDto createCategory(CategoryDto categoryDto);
	//Update 
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	//Delete
	void deleteCategory(Integer categoryId);
	//get
	CategoryDto getCategory(Integer categoryId);
	//get All
	List<CategoryDto> getCategories();
	

}
