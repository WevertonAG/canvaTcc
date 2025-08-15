package com.example.canvaTcc.repository;


import com.example.canvaTcc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    List<User>findByNameContainingIgnoreCaseOrLoginContainingIgnoreCase(String name, String login);
}
