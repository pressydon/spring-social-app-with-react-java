package com.precious.springsocialappwithreact.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socialPost")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "users")
    private String user;

    @Column(name = "contents")
    private String content;

    @Column(name = "post-like")
    private int like;

    @Column(name = "post-unlike")
    private int unlike;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "postId")
    List<Comment> comments = new ArrayList<>();

    public Post(){
        super();
    }
    public Post( String user, String content, int like, int unlike, List<Comment> comments) {
         super();
        this.user = user;
        this.content = content;
        this.like = like;
        this.unlike = unlike;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getUnlike() {
        return unlike;
    }

    public void setUnlike(int unlike) {
        this.unlike = unlike;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
