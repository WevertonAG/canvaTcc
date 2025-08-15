package com.example.canvaTcc.repository;

import com.example.canvaTcc.model.QuadroPostId;
import com.example.canvaTcc.model.entity.QuadroPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadroPostRepository extends JpaRepository<QuadroPost, Integer> {
    boolean existsById(QuadroPostId id);
}
