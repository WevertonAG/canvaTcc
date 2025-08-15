package com.example.canvaTcc.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quadros")
public class Quadro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "descriptions")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    @JoinTable(
            name = "quadro_post",
            joinColumns = @JoinColumn(name = "quadro_id"),
            inverseJoinColumns = @JoinColumn(name ="post_id")
    )
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "quadro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuadroPost> quadroPosts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "quadro_colaboradores",
            joinColumns = @JoinColumn(name = "quadros_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private Set<User> colaboradores = new HashSet<>();

    public Set<User> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Set<User> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
