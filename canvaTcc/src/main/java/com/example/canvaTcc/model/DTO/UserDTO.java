package com.example.canvaTcc.model.DTO;
import com.example.canvaTcc.model.entity.User;

import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String login;
    private List<PostResumeDTO> posts;


    public UserDTO() {}

    public UserDTO(Integer id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<PostResumeDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResumeDTO> posts) {
        this.posts = posts;
    }
}
