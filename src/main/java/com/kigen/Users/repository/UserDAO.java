package com.kigen.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kigen.Users.model.EUser;

public interface UserDAO extends JpaRepository<EUser, Integer> {
    
}
