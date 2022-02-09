package com.swayne.comments.services;

import com.swayne.comments.models.Cp;
import com.swayne.comments.repositories.CpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpService {
    @Autowired
    private CpRepo cpRepo;

    public Cp create(Cp cp){
        return cpRepo.save(cp);
    }
}
