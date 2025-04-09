package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.Category;

public class PostResumeDTO {

    private int id;
    private String description;
    private Category category;

    public PostResumeDTO() {}

    public PostResumeDTO(int id, String description, Category category) {
        this.id = id;
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
