package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.User;

public class LoginDTO {
    private Integer id;
    private String login;
    private String password;


    public LoginDTO() {
    }
    public LoginDTO(User user) {
        if (user != null) {
            this.id = user.getId();
            this.login = user.getLogin();
            this.password = user.getPassword();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
