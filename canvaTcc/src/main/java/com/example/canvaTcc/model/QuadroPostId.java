package com.example.canvaTcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuadroPostId implements Serializable {

    @Column(name = "quadro_id")
    private Integer quadroId;

    @Column(name = "post_id")
    private Integer postId;

    // Construtor vazio (obrigatório pro JPA)
    public QuadroPostId() {}

    public QuadroPostId(Integer quadroId, Integer postId) {
        this.quadroId = quadroId;
        this.postId = postId;
    }

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
