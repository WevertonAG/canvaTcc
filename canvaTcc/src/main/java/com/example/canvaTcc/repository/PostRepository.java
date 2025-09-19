package com.example.canvaTcc.repository;

import com.example.canvaTcc.model.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Post p WHERE p.quadro.id = :quadroId")
    void deleteByQuadroId(@Param("quadroId") Integer quadroId);
}
