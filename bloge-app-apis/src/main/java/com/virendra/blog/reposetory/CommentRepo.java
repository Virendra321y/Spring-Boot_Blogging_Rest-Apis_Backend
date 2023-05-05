package com.virendra.blog.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virendra.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
