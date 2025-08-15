package com.example.canvaTcc.repository;

import com.example.canvaTcc.model.entity.Quadro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuadroRepository extends JpaRepository<Quadro, Integer> {
    long countByOwnerId(Integer id);

    List<Quadro> findByOwnerId(Integer id);

    @Query("SELECT q FROM Quadro q JOIN q.colaboradores c WHERE c.id = :user_Id")
    List<Quadro> findByColaboratorId(@Param("user_Id") Integer id);

    @Query("""
                SELECT q FROM Quadro q
                WHERE q.id = :quadroId AND q.owner.id = :userId
            """)
    Optional<Quadro> findByIdAndOwnerId(Integer id, Integer ownerId);
}
