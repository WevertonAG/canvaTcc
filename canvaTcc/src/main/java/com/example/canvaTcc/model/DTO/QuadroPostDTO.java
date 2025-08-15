package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.QuadroPost;

public class QuadroPostDTO {
    private Integer quadroId;
    private Integer postId;

    public QuadroPostDTO() {}

    public QuadroPostDTO(QuadroPost rel) {
        this.quadroId = rel.getQuadro().getId();
        this.postId = rel.getPost().getId();
    }

    // Getters e Setters
    public Integer getQuadroId() {
        return quadroId;
    }

    public void setQuadroId(Integer quadroId) {
        this.quadroId = quadroId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
