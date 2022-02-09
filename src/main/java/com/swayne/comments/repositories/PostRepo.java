package com.swayne.comments.repositories;

import java.util.List;

import com.swayne.comments.models.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post,Long> {
    List<Post> findAll();

}
