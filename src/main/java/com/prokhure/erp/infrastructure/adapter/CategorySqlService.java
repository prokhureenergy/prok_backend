package com.prokhure.erp.infrastructure.adapter;

import com.prokhure.erp.domain.ports.spi.CategoryPesistencePort;
import com.prokhure.erp.infrastructure.entity.products.Category;
import com.prokhure.erp.infrastructure.mapper.CategoryMapper;
import com.prokhure.erp.infrastructure.repository.products.CategoryRepository;
import com.prokhure.erp.service.model.CategoryDto;
import com.prokhure.erp.service.model.CategoryRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public class CategorySqlService implements CategoryPesistencePort {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategorySqlService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Category saveCategory(CategoryRequestDto category) {
        return repository.save(mapper.mapToCategory(category));
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category getCategoryById(String categoryId) {
        return repository.findByCategoryUuid(categoryId).orElse(null);
    }

    @Override
    public Page<Category> findCategoryByStatusPaginated(String status, Pageable pageable) {
        return repository.findByStatus(status,pageable);
    }

    @Override
    public Page<Category> findCategoryByDateCreatedPaginated(LocalDateTime dateCreated, Pageable pageable) {
        return repository.findByDateCreated(dateCreated,pageable);
    }

    @Override
    public Page<Category> findCategoryByDateAndStatusPaginated(LocalDateTime dateCreated, String status, Pageable pageable) {
        return repository.findByDateCreatedAndStatus(dateCreated, status, pageable);
    }

    @Override
    public Page<Category> findAllCategories(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CategoryDto getCategoryMap(Category category) {
        return mapper.mapToCategoryResponseDto(category);
    }
}
