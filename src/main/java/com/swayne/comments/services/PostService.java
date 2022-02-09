package com.swayne.comments.services;

import java.util.List;

import com.swayne.comments.models.Post;
import com.swayne.comments.repositories.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public List<Post> getAll(){
        return postRepo.findAll();
    }

    public Post getOne(Long id){
        return postRepo.findById(id).orElse(null);
    }

    public Post create(Post post){
        return postRepo.save(post);
    }

    public Post update(Post post){
        return postRepo.save(post);
    }

    public void delete(Long id){
        postRepo.deleteById(id);
    }

}
