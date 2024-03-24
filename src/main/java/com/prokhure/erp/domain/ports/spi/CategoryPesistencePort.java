package com.prokhure.erp.domain.ports.spi;

import com.prokhure.erp.infrastructure.entity.products.Category;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.service.model.CategoryDto;
import com.prokhure.erp.service.model.CategoryRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface CategoryPesistencePort {
    Category saveCategory(CategoryRequestDto category);
    Category updateCategory(Category category);
    Category getCategoryById (String categoryId);
    Page<Category> findCategoryByStatusPaginated(String status, Pageable pageable);
    Page<Category> findCategoryByDateCreatedPaginated(LocalDateTime dateCreated, Pageable pageable);
    Page<Category> findCategoryByDateAndStatusPaginated(LocalDateTime dateCreated, String userRole, Pageable pageable);
    Page<Category> findAllCategories(Pageable pageable);
    CategoryDto getCategoryMap(Category category);
}
