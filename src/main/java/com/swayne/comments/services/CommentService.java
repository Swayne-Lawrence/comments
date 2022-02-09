package com.swayne.comments.services;

import java.util.List;

import com.swayne.comments.models.Comment;
import com.swayne.comments.repositories.CommentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> getAll(){
        return commentRepo.findAll();
    }

    public Comment getOne(Long id){
        return commentRepo.findById(id).orElse(null);
    }

    public Comment create(Comment comment){
        return commentRepo.save(comment);
    }

    public Comment update(Comment comment){
        return commentRepo.save(comment);
    }

    public void delete(Long id){
        commentRepo.deleteById(id);
    }

}
