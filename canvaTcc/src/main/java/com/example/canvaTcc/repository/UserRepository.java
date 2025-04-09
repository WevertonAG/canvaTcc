package com.example.canvaTcc.repository;


import com.example.canvaTcc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
