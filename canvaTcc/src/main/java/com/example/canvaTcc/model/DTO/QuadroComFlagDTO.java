package com.example.canvaTcc.model.DTO;

public class QuadroComFlagDTO {
    private Integer id;
    private String name;
    private boolean owener;
    private String description;



    public QuadroComFlagDTO(Integer id, String name, boolean owener, String description) {
        this.id = id;
        this.name = name;
        this.owener = owener;
        this.description = description;
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

    public boolean isOwener() {
        return owener;
    }

    public void setOwener(boolean owener) {
        this.owener = owener;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
