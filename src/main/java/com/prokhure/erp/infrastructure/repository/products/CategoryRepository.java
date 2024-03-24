package com.prokhure.erp.infrastructure.repository.products;

import com.prokhure.erp.infrastructure.entity.products.Category;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryUuid(String categoryUuid);
    Page<Category> findByStatus(String status, Pageable pageable);
    Page<Category> findByDateCreated(LocalDateTime dateCreated, Pageable pageable);
    Page<Category> findByDateCreatedAndStatus(LocalDateTime dateCreated, String status, Pageable pageable);
}
