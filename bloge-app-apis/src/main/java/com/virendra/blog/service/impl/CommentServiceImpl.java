package com.virendra.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virendra.blog.entities.Comment;
import com.virendra.blog.entities.Post;
import com.virendra.blog.exceptions.ResourceNotFoundException;
import com.virendra.blog.payloads.CommentDto;
import com.virendra.blog.payloads.PostResponse;
import com.virendra.blog.reposetory.CommentRepo;
import com.virendra.blog.reposetory.PostRepo;
import com.virendra.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;//what is use of modelMapper??
	

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postid) {
		
		Post post = this.postRepo.findById(postid).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postid));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	
	
	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);

	}

}
