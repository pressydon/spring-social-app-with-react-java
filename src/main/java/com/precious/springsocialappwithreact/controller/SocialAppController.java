package com.precious.springsocialappwithreact.controller;

import com.precious.springsocialappwithreact.model.Comment;
import com.precious.springsocialappwithreact.model.Post;
import com.precious.springsocialappwithreact.repository.CommentRepository;
import com.precious.springsocialappwithreact.repository.PostRepository;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social-app")
@CrossOrigin(origins = "http://localhost:3000/")
public class SocialAppController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/posts")
    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @PutMapping("/likes/{id}/{like}")
    public ResponseEntity<Post> updateLike(@PathVariable Long id, @PathVariable int like ){
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new FetchNotFoundException("Post", id));
        post.setLike(like + 1);

        Post postUpdated = postRepository.save(post);

        return new ResponseEntity<>(postUpdated, HttpStatus.OK);
    }

    @PutMapping("/unlikes/{id}/{unlike}")
    public ResponseEntity<Post> updateUnlike(@PathVariable Long id, @PathVariable int unlike ){
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new FetchNotFoundException("Post", id));
        post.setUnlike(unlike + 1);

        Post postUpdated = postRepository.save(post);

        return new ResponseEntity<>(postUpdated, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postRepository.findById(id).orElseThrow(()-> new FetchNotFoundException("Post", id));
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<Post> updateComment(@PathVariable Long id, @RequestBody Comment comment){
        Post post = postRepository.findById(id).orElseThrow(()-> new FetchNotFoundException("Post", id));
        post.getComments().add(comment);
        Post postUpdated = postRepository.save(post);

        return new ResponseEntity<>(postUpdated, HttpStatus.OK);
    }
}
