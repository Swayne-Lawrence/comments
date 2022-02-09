package com.swayne.comments.repositories;

import com.swayne.comments.models.Cp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpRepo extends CrudRepository<Cp,Long> {

}
