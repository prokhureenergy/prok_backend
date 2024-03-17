package com.prokhure.erp.infrastructure.entity.users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prok_vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_uuid", length = 50)
    private String vendorUuid;
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "vendor_name", length = 300)
    private String vendorName;

    @Column(name = "vendor_reg_number", length = 50)
    private String vendorRegistrationNumber;

    @Column(name = "vendor_desc", length = 500)
    private String vendorDesc;

    @Column(name = "vendor_category", length = 100)
    private String vendorCategory;

    @Column(name = "contact_person_one_id", length = 50)
    private String contactPersonOne;

    @Column(name = "contact_person_two_id", length = 50)
    private String contactPersonTwo;

    @Column(name = "phone_country_code", length = 10)
    private String phoneCountryCode;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "is_email_verified")
    private boolean isEmailVerified;

    @Column(name = "is_vendor_verified")
    private boolean isVendorVerified;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @Column(name = "status",length = 50)
    private String status;

    @Column(name = "vendor_type",length = 50)
    private String vendorType;

    @Column(name = "verified_by_id",length = 50)
    private String verifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorUuid() {
        return vendorUuid;
    }

    public void setVendorUuid(String vendorUuid) {
        this.vendorUuid = vendorUuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorRegistrationNumber() {
        return vendorRegistrationNumber;
    }

    public void setVendorRegistrationNumber(String vendorRegistrationNumber) {
        this.vendorRegistrationNumber = vendorRegistrationNumber;
    }

    public String getVendorDesc() {
        return vendorDesc;
    }

    public void setVendorDesc(String vendorDesc) {
        this.vendorDesc = vendorDesc;
    }

    public String getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(String vendorCategory) {
        this.vendorCategory = vendorCategory;
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

    public boolean isVendorVerified() {
        return isVendorVerified;
    }

    public void setVendorVerified(boolean vendorVerified) {
        isVendorVerified = vendorVerified;
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

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
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
        this.vendorUuid = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void beforeUpdate() {this.dateUpdated = LocalDateTime.now();}

}
