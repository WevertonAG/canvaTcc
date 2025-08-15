package com.example.canvaTcc.model.DTO;

public class AddPostToQuadroDTO {
    private Integer quadroId;
    private Integer postId;

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
}
