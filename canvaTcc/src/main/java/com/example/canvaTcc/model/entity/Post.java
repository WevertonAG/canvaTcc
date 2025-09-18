package com.example.canvaTcc.model.entity;

import com.example.canvaTcc.model.convert.ConverterCategory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.io.Serializable;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Convert(converter = ConverterCategory.class)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "quadro_id", nullable = false)
    private Quadro quadro;

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

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
