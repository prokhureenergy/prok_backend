package com.prokhure.erp.infrastructure.entity.users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prok_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_uuid", length = 50, unique = true)
    private String companyUuid;

    @Column(name = "company_name", length = 250)
    private String companyName;

    @Column(name = "company_desc", length = 500)
    private String companyDesc;

    @Column(name = "company_category", length = 100)
    private String companyCategory;

    @Column(name = "contact_person_one_id", length = 50)
    private String contactPersonOne;

    @Column(name = "contact_person_two_id", length = 50)
    private String contactPersonTwo;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "is_email_verified")
    private boolean isEmailVerified;

    @Column(name = "is_company_verified")
    private boolean isCompanyVerified;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

     @Column(name = "status", length = 50)
    private String status;

    @Column(name = "verified_by_id", length = 50)
    private String verifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    public String getContactPersonOne() {
        return contactPersonOne;
    }

    public void setContactPersonOne(String contactPersonOne) {
        this.contactPersonOne = contactPersonOne;
    }

    public String getContactPersonTwo() {
        return contactPersonTwo;
    }

    public void setContactPersonTwo(String contactPersonTwo) {
        this.contactPersonTwo = contactPersonTwo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isCompanyVerified() {
        return isCompanyVerified;
    }

    public void setCompanyVerified(boolean companyVerified) {
        isCompanyVerified = companyVerified;
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

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    @PrePersist
    public void beforeSave() {
        this.dateCreated = LocalDateTime.now();
        this.companyUuid = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void beforeUpdate() {this.dateUpdated = LocalDateTime.now();}
}
