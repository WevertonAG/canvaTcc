package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.Category;

public class PostRequestDTO {

    private Integer id;
    private String description;
    private Category category;
    private Integer quadroId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuadroId() {
        return quadroId;
    }

    public void setQuadroId(Integer quadroId) {
        this.quadroId = quadroId;
    }
}
