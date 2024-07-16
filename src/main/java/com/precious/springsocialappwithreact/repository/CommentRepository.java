package com.precious.springsocialappwithreact.repository;

import com.precious.springsocialappwithreact.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
