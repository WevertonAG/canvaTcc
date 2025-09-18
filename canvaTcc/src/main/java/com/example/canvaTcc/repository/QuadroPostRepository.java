package com.example.canvaTcc.repository;

import com.example.canvaTcc.model.QuadroPostId;
import com.example.canvaTcc.model.entity.Post;
import com.example.canvaTcc.model.entity.QuadroPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface QuadroPostRepository extends JpaRepository<QuadroPost, QuadroPostId> {
    boolean existsById(QuadroPostId id);

    @Query("SELECT qp.post FROM QuadroPost qp WHERE qp.quadro.id = :quadroId")
    List<Post> findPostsByQuadroId(@Param("quadroId") Integer quadroId);
}
