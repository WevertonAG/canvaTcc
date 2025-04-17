package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.User;

public class LoginDTO {
    private Integer id;
    private String login;
    private String password;
    private String name;


    public LoginDTO() {
    }
    public LoginDTO(User user) {
        if (user != null) {
            this.id = user.getId();
            this.login = user.getLogin();
            this.password = user.getPassword();
            this.name = user.getName();
        }
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


    public String getName() {
        return name;
    }

}
