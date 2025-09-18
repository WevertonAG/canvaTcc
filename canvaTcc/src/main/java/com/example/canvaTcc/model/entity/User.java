package com.example.canvaTcc.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true, nullable = false)
    private String login;
    private String password;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Post> posts;
    @ManyToMany(mappedBy = "colaboradores")
    private Set<Quadro> quadrosColaborando = new HashSet<>();


    public Set<Quadro> getQuadrosColaborando() {
        return quadrosColaborando;
    }

    public void setQuadrosColaborando(Set<Quadro> quadrosColaborando) {
        this.quadrosColaborando = quadrosColaborando;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public List<Post> getPosts() {
      //  return posts;
    //}

    //public void setPosts(List<Post> posts) {
      //  this.posts = posts;
    //}
}
