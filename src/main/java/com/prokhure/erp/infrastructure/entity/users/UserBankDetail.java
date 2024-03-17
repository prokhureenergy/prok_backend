package com.prokhure.erp.infrastructure.entity.users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prok_user_bank_detail")
public class UserBankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_bank_uuid", length = 50)
    private String userBankUuid;
    @Column(name = "bank_uuid", length = 50)
    private String bankUuid;
    @Column(name = "user_uuid", length = 50)
    private String userUuid;
    @Column(name = "account_number", length = 20)
    private String accountNumber;
    @Column(name = "bank_name", length = 250)
    private String bankName;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserBankUuid() {
        return userBankUuid;
    }

    public void setUserBankUuid(String userBankUuid) {
        this.userBankUuid = userBankUuid;
    }

    public String getBankUuid() {
        return bankUuid;
    }

    public void setBankUuid(String bankUuid) {
        this.bankUuid = bankUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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

    @PrePersist
    public void beforeSave() {
        this.dateCreated = LocalDateTime.now();
        this.userBankUuid = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void beforeUpdate() {this.dateUpdated = LocalDateTime.now();}
}
