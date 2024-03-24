package com.prokhure.erp.infrastructure.entity.products;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prok_category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_uuid", length = 50)
    private String categoryUuid;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "description", length = 500)
    private String description;
    @Column(name = "parent_category_id", length = 50)
    private String parentCategory;

    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @Column(name = "created_by_id", length = 50)
    private String createdBy;

    @Column(name = "creators_role", length = 50)
    private String creatorsRole;
    @Column(name = "status", length = 50)
    private String status;

    @PrePersist
    public void beforeSave() {
        this.dateCreated = LocalDateTime.now();
        this.categoryUuid = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void beforeUpdate() {this.dateUpdated = LocalDateTime.now();}
}
