package com.example.canvaTcc.model.DTO;

import com.example.canvaTcc.model.entity.Category;

 public class PostDTO {
        private int id;
        private String description;
        private Category category;
        private int user;

        public PostDTO() {}

        public PostDTO(Integer id, String description, Category category, Integer userId) {
            this.id = id;
            this.description = description;
            this.category = category;
            this.user = userId;
        }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public Category getCategory() {
         return category;
     }

     public void setCategory(Category category) {
         this.category = category;
     }

     public Integer getUser() {
         return user;
     }

     public void setUser(Integer user) {
         this.user = user;
     }
 }

