package com.prokhure.erp.domain.service;

import com.prokhure.erp.domain.ports.api.CategoryServicePort;
import com.prokhure.erp.domain.ports.spi.CategoryPesistencePort;
import com.prokhure.erp.infrastructure.entity.products.Category;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.infrastructure.mapper.UserRegAuthDto;
import com.prokhure.erp.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import static com.prokhure.erp.domain.service.Utilities.convertToLocalDateTime;
import static com.prokhure.erp.domain.service.Utilities.throwNotException;

public class CategoryServiceImpl implements CategoryServicePort {

    private final CategoryPesistencePort categoryPesistencePort;
    public CategoryServiceImpl(CategoryPesistencePort categoryPesistencePort){
        this.categoryPesistencePort = categoryPesistencePort;
    }
    @Override
    public CategoryResponseDto processNewCategory(CategoryRequestDto category) {
        var categoryResponseData = categoryPesistencePort.saveCategory(category);
        return new CategoryResponseDto()
                .status("00")
                .description("successful")
                .data(categoryPesistencePort.getCategoryMap(categoryResponseData));
    }

    @Override
    public CategoryListResponseDto getPaginatedCategories(int page, int pageSize, String status, Date dateCreated) {
        pageSize = pageSize <= 0 ? 20 : pageSize;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Category> categoryPage;
        if(status != null && dateCreated != null){
            categoryPage = categoryPesistencePort.findCategoryByDateAndStatusPaginated(convertToLocalDateTime(dateCreated),status,pageable);
        } else if(status != null && dateCreated == null) {
            categoryPage = categoryPesistencePort.findCategoryByStatusPaginated(status,pageable);
        } else if((dateCreated != null) && (status == null)) {
            categoryPage = categoryPesistencePort.findCategoryByDateCreatedPaginated(convertToLocalDateTime(dateCreated),pageable);
        }else{
            categoryPage = categoryPesistencePort.findAllCategories(pageable);
        }
        PageInfo pageInfo = new PageInfo()
                .totalItems((int)categoryPage.getTotalElements())
                .totalPages((int)categoryPage.getTotalElements());
        List<CategoryDto> categoryDtos = categoryPage.getContent().stream()
                .map(categoryPesistencePort::getCategoryMap)
                .toList();
        return new CategoryListResponseDto()
                .data(new CategoryListResponseDtoData().categories(categoryDtos).pageInfo(pageInfo))
                .status("00")
                .description("successful");
    }

    @Override
    public CategoryResponseDto getCategoryById(String categoryId) {
        var category = categoryPesistencePort.getCategoryById(categoryId);
        if(category == null)
            throwNotException("404", "category not found");
        return new CategoryResponseDto()
                .status("00")
                .description("successful")
                .data(categoryPesistencePort.getCategoryMap(category));
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto category) {
        var categoryData = categoryPesistencePort.getCategoryById(category.getCategoryId().toString());
        if(categoryData == null)
            throwNotException("404", "category not found");
        categoryData.setParentCategory(category.getParentCategory() != null
                ? category.getParentCategory() : categoryData.getParentCategory());
        categoryData.setName(category.getName() != null
                ? category.getName() : categoryData.getName());
        categoryData.setDescription(category.getDescription() != null
                ? category.getDescription() : categoryData.getDescription());
        categoryData = categoryPesistencePort.updateCategory(categoryData);
        return new CategoryResponseDto()
                .status("00")
                .description("successful")
                .data(categoryPesistencePort.getCategoryMap(categoryData));
    }

    @Override
    public CategoryResponseDto toggleCategoryStatus(String categoryId) {
        var category = categoryPesistencePort.getCategoryById(categoryId);
        if(category == null)
            throwNotException("404", "category not found");
        String status = category.getStatus().equals("ACTIVE") ? "INACTIVE" : "ACTIVE";
        category.setStatus(status);
        category = categoryPesistencePort.updateCategory(category);
        return new CategoryResponseDto()
                .status("00")
                .description("successful category updated")
                .data(categoryPesistencePort.getCategoryMap(category));
    }
}
