package com.services;

import com.daos.PostDao;
import com.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public List<Post> getAllPost(){
        return postDao.getAllPost();
    }

    public void addPost(Post post){
        postDao.addPost(post);
    }

    public Post getPostById(int id){
        return postDao.getPostById(id);
    }

    public void updatePost(Post post){
        postDao.updatePost(post);
    }

    public void deletePost(int id){
        postDao.deletePost(id);
    }
}
