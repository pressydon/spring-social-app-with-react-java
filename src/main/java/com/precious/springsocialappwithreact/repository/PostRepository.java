package com.precious.springsocialappwithreact.repository;

import com.precious.springsocialappwithreact.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
