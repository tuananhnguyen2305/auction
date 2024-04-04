package com.uet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uet.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
}
