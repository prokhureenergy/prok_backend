package com.prokhure.erp.infrastructure.entity.users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prok_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private Long id;

    @Column(name = "role_uuid",length = 50)
    private String roleUUID;

    @Column(name = "role_name",length = 50)
    private String roleName;
    @Column(name = "description",length = 100)
    private String description;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleUUID() {
        return roleUUID;
    }

    public void setRoleUUID(String roleUUID) {
        this.roleUUID = roleUUID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PrePersist
    public void beforeSave() {
        this.dateCreated = LocalDateTime.now();
        this.roleUUID = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void beforeUpdate() {this.dateUpdated = LocalDateTime.now();}
}
