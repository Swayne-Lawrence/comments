package com.swayne.comments.validators;

import com.swayne.comments.models.User;
import com.swayne.comments.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValid implements Validator{
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        User user= (User) target;

        if(!(user.getConfirmPw().equals(user.getPassword()))){
            errors.rejectValue("password", "Match","Passwords do not match");
        }

        if(userRepo.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Unique", "Email is already taken");
        }
    }

}
