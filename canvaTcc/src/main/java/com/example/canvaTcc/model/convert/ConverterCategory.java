package com.example.canvaTcc.model.convert;

import com.example.canvaTcc.model.entity.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ConverterCategory implements AttributeConverter<Category, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Category category) {
        return category !=null ? category.getValue() : null;
    }

    @Override
    public Category convertToEntityAttribute(Integer dbData) {
        return dbData !=null? Category.fromValue(dbData):null;
    }
}
