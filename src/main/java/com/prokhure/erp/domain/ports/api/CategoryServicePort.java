package com.prokhure.erp.domain.ports.api;

import com.prokhure.erp.service.model.CategoryListResponseDto;
import com.prokhure.erp.service.model.CategoryRequestDto;
import com.prokhure.erp.service.model.CategoryResponseDto;

import java.util.Date;

public interface CategoryServicePort {
    CategoryResponseDto processNewCategory(CategoryRequestDto category);
    CategoryListResponseDto getPaginatedCategories(int page, int pageSize, String role, Date dateCreated);
    CategoryResponseDto getCategoryById(String categoryId);
    CategoryResponseDto updateCategory(CategoryRequestDto category);
    CategoryResponseDto toggleCategoryStatus(String categoryId);
}
