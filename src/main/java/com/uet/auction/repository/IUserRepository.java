package com.uet.auction.repository;

import com.uet.auction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
