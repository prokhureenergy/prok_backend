package com.prokhure.erp.application.controller;

import com.prokhure.erp.domain.ports.api.CategoryServicePort;
import com.prokhure.erp.service.api.CategoryApi;
import com.prokhure.erp.service.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class CategoryController implements CategoryApi {

    private final CategoryServicePort categoryServicePort;

    public CategoryController(CategoryServicePort categoryServicePort){
        this.categoryServicePort = categoryServicePort;
    }
    @Override
    public ResponseEntity<CategoryResponseDto> addCategory(CategoryRequestDto categoryRequestDto) {
        var response = categoryServicePort.processNewCategory(categoryRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> getCategoryById(UUID categoryId) {
        var response = categoryServicePort.getCategoryById(categoryId.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryListResponseDto> listCategories(Integer page, Integer pageSize, String status, Date dateCreated) {
        var response = categoryServicePort.getPaginatedCategories(page, pageSize, status, dateCreated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> updateCategory(CategoryRequestDto categoryRequestDto) {
        var response = categoryServicePort.updateCategory(categoryRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> updateCategoryById(UUID categoryId) {
        var response = categoryServicePort.toggleCategoryStatus(categoryId.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
