package com.example.canvaTcc.model.entity;

import com.example.canvaTcc.model.QuadroPostId;
import jakarta.persistence.*;

@Entity
@Table(name = "quadro_post")

public class QuadroPost {

    @EmbeddedId
    private QuadroPostId id = new QuadroPostId();

    @ManyToOne
    @MapsId("quadroId")
    @JoinColumn(name = "quadro_id")
    private Quadro quadro;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    public QuadroPost(QuadroPostId id, Quadro quadro, Post post) {
        this.id = id;
        this.quadro = quadro;
        this.post = post;
    }

    public QuadroPost() {

    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public QuadroPostId getId() {
        return id;
    }

    public void setId(QuadroPostId id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
