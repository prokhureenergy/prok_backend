package com.prokhure.erp.infrastructure.entity.views;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "all_users_view")
public class UsersView {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "business_category")
    private String businessCategory;

    @Column(name = "business_desc")
    private String businessDesc;

    @Column(name = "name")
    private String name;

    @Column(name = "business_reg_number")
    private String businessRegNumber;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "email")
    private String email;

    @Column(name = "is_business_verified")
    private Boolean isBusinessVerified;

    @Column(name = "is_email_verified")
    private Boolean isEmailVerified;

    @Column(name = "phone_country_code")
    private String phoneCountryCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "verified_by_id")
    private String verifiedById;
    @Column(name = "date_created",columnDefinition = "TIMESTAMP")
    private LocalDateTime dateCreated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessRegNumber() {
        return businessRegNumber;
    }

    public void setBusinessRegNumber(String businessRegNumber) {
        this.businessRegNumber = businessRegNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBusinessVerified() {
        return isBusinessVerified;
    }

    public void setBusinessVerified(Boolean businessVerified) {
        isBusinessVerified = businessVerified;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getVerifiedById() {
        return verifiedById;
    }

    public void setVerifiedById(String verifiedById) {
        this.verifiedById = verifiedById;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
