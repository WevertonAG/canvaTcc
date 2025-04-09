package com.example.canvaTcc.repository;

import com.example.canvaTcc.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
