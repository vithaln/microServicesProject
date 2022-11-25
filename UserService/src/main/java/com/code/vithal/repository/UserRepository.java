package com.code.vithal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.vithal.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
