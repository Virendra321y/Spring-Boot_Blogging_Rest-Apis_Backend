package com.virendra.blog.service;

import com.virendra.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postid);
	
	void deleteComment(Integer commentId);
	
	

}
