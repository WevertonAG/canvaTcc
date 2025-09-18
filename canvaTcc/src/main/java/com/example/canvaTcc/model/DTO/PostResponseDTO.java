package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.Category;

public class PostResponseDTO {
    private Integer id;
    private String description;
    private Category category;
    private Integer quadroId;

    public PostResponseDTO() {

    }
    public record PostResponse2DTO(Integer id, String description, Category category) {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuadroId() {
        return quadroId;
    }

    public void setQuadroId(Integer quadroId) {
        this.quadroId = quadroId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostResponseDTO(Integer id, String description, Category category, Integer quadroId) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.quadroId = quadroId;
    }

    public void setCategory(Category category) {
    }
}
