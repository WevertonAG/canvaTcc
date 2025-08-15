package com.example.canvaTcc.model.entity;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class QuadroPostId implements Serializable {
    @Column(name = "quadro_id")
    private Integer quadroId;

    @Column(name = "post_id")
    private Integer postId;

    // getters e setters
    public QuadroPostId() {}

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getQuadroId() {
        return quadroId;
    }

    public void setQuadroId(Integer quadroId) {
        this.quadroId = quadroId;
    }

    // equals e hashCode - OBRIGATÓRIOS para chave composta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuadroPostId)) return false;
        QuadroPostId that = (QuadroPostId) o;
        return Objects.equals(quadroId, that.quadroId) &&
                Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quadroId, postId);
    }
}
