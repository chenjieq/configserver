package com.config.configserver1.dao;

import com.config.configserver1.entity.configserver;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface configserverRepository extends CrudRepository<configserver, Integer> {
    Iterable<configserver> findByApplicationAndAprofileAndLabel(String application, String aprofile, String label);

}