package com.daos;

import com.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostDao {

    List<Post> getAllPost();

    void addPost(Post post);

    Post getPostById(int id);

    void updatePost(Post post);

    void deletePost(int id);
}
