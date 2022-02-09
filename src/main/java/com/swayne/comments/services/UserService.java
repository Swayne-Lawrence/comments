package com.swayne.comments.services;

import java.util.List;

import com.swayne.comments.models.User;
import com.swayne.comments.repositories.UserRepo;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User getOne(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public User create(User user){
        String hashed=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public boolean auth(String email, String password){
        User user= userRepo.findByEmail(email);
        if(user==null){
            return false;
        }
        if(!(BCrypt.checkpw(password, user.getPassword()))){
            return false;
        }
        return true;
    }

}
