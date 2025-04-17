package com.example.canvaTcc.model.DTO;

public class LoginResponseDTO {
    private Integer id;
    private String name;

    public LoginResponseDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
