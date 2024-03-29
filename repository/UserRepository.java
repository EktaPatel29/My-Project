package com.pcpartpicker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcpartpicker.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> 
{
    public User findByUserName(String username);    
}