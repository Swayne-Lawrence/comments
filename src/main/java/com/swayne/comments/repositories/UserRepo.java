package com.swayne.comments.repositories;

import java.util.List;

import com.swayne.comments.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    List<User> findAll();
    User findByEmail(String email);

}
