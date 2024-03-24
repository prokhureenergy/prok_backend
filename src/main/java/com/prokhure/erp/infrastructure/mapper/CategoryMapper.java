package com.prokhure.erp.infrastructure.mapper;

import com.prokhure.erp.infrastructure.entity.products.Category;
import com.prokhure.erp.service.model.CategoryDto;
import com.prokhure.erp.service.model.CategoryRequestDto;
import com.prokhure.erp.service.model.CategoryResponseDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public class CategoryMapper {

    public Category mapToCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        category.setParentCategory(categoryRequestDto.getParentCategory());
        category.setStatus("ACTIVE");
        return category;
    }

    public CategoryDto mapToCategoryResponseDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(UUID.fromString(category.getCategoryUuid()));
        categoryDto.setParentCategory(category.getParentCategory());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setName(category.getName());
        categoryDto.setStatus(category.getStatus());
        categoryDto.setDateCreated(convertToLocalDateTimeToDate(category.getDateCreated()));
        return categoryDto;
    }

    private  Date convertToLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
