package com.prokhure.erp.infrastructure.repository.views;

import com.prokhure.erp.infrastructure.entity.views.UsersView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UsersViewRepository extends JpaRepository<UsersView, String> {
    Page<UsersView> findByUserRole(String userRole, Pageable pageable);
    Page<UsersView> findByDateCreated(LocalDateTime dateCreated, Pageable pageable);

    Page<UsersView> findByDateCreatedAndUserRole(LocalDateTime dateCreated, String userRole, Pageable pageable);


}
