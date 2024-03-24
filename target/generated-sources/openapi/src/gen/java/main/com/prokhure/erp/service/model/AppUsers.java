package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AppUsers
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class AppUsers {

  private String businessCategory;

  private String businessDesc;

  private String name;

  private String businessRegNumber;

  private String businessType;

  private String email;

  private Boolean isBusinessVerified;

  private Boolean isEmailVerified;

  private String phoneCountryCode;

  private String phoneNumber;

  private String status;

  private String userRole;

  private String userUuid;

  private String verifiedById;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date dateCreated;

  public AppUsers businessCategory(String businessCategory) {
    this.businessCategory = businessCategory;
    return this;
  }

  /**
   * Get businessCategory
   * @return businessCategory
  */
  
  @Schema(name = "businessCategory", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessCategory")
  public String getBusinessCategory() {
    return businessCategory;
  }

  public void setBusinessCategory(String businessCategory) {
    this.businessCategory = businessCategory;
  }

  public AppUsers businessDesc(String businessDesc) {
    this.businessDesc = businessDesc;
    return this;
  }

  /**
   * Get businessDesc
   * @return businessDesc
  */
  
  @Schema(name = "businessDesc", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessDesc")
  public String getBusinessDesc() {
    return businessDesc;
  }

  public void setBusinessDesc(String businessDesc) {
    this.businessDesc = businessDesc;
  }

  public AppUsers name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppUsers businessRegNumber(String businessRegNumber) {
    this.businessRegNumber = businessRegNumber;
    return this;
  }

  /**
   * Get businessRegNumber
   * @return businessRegNumber
  */
  
  @Schema(name = "businessRegNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessRegNumber")
  public String getBusinessRegNumber() {
    return businessRegNumber;
  }

  public void setBusinessRegNumber(String businessRegNumber) {
    this.businessRegNumber = businessRegNumber;
  }

  public AppUsers businessType(String businessType) {
    this.businessType = businessType;
    return this;
  }

  /**
   * Get businessType
   * @return businessType
  */
  
  @Schema(name = "businessType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessType")
  public String getBusinessType() {
    return businessType;
  }

  public void setBusinessType(String businessType) {
    this.businessType = businessType;
  }

  public AppUsers email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AppUsers isBusinessVerified(Boolean isBusinessVerified) {
    this.isBusinessVerified = isBusinessVerified;
    return this;
  }

  /**
   * Get isBusinessVerified
   * @return isBusinessVerified
  */
  
  @Schema(name = "isBusinessVerified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isBusinessVerified")
  public Boolean getIsBusinessVerified() {
    return isBusinessVerified;
  }

  public void setIsBusinessVerified(Boolean isBusinessVerified) {
    this.isBusinessVerified = isBusinessVerified;
  }

  public AppUsers isEmailVerified(Boolean isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
    return this;
  }

  /**
   * Get isEmailVerified
   * @return isEmailVerified
  */
  
  @Schema(name = "isEmailVerified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isEmailVerified")
  public Boolean getIsEmailVerified() {
    return isEmailVerified;
  }

  public void setIsEmailVerified(Boolean isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
  }

  public AppUsers phoneCountryCode(String phoneCountryCode) {
    this.phoneCountryCode = phoneCountryCode;
    return this;
  }

  /**
   * Get phoneCountryCode
   * @return phoneCountryCode
  */
  
  @Schema(name = "phoneCountryCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneCountryCode")
  public String getPhoneCountryCode() {
    return phoneCountryCode;
  }

  public void setPhoneCountryCode(String phoneCountryCode) {
    this.phoneCountryCode = phoneCountryCode;
  }

  public AppUsers phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  */
  
  @Schema(name = "phoneNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public AppUsers status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public AppUsers userRole(String userRole) {
    this.userRole = userRole;
    return this;
  }

  /**
   * Get userRole
   * @return userRole
  */
  
  @Schema(name = "userRole", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userRole")
  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public AppUsers userUuid(String userUuid) {
    this.userUuid = userUuid;
    return this;
  }

  /**
   * Get userUuid
   * @return userUuid
  */
  
  @Schema(name = "userUuid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userUuid")
  public String getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(String userUuid) {
    this.userUuid = userUuid;
  }

  public AppUsers verifiedById(String verifiedById) {
    this.verifiedById = verifiedById;
    return this;
  }

  /**
   * Get verifiedById
   * @return verifiedById
  */
  
  @Schema(name = "verifiedById", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("verifiedById")
  public String getVerifiedById() {
    return verifiedById;
  }

  public void setVerifiedById(String verifiedById) {
    this.verifiedById = verifiedById;
  }

  public AppUsers dateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Get dateCreated
   * @return dateCreated
  */
  @Valid 
  @Schema(name = "dateCreated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateCreated")
  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppUsers appUsers = (AppUsers) o;
    return Objects.equals(this.businessCategory, appUsers.businessCategory) &&
        Objects.equals(this.businessDesc, appUsers.businessDesc) &&
        Objects.equals(this.name, appUsers.name) &&
        Objects.equals(this.businessRegNumber, appUsers.businessRegNumber) &&
        Objects.equals(this.businessType, appUsers.businessType) &&
        Objects.equals(this.email, appUsers.email) &&
        Objects.equals(this.isBusinessVerified, appUsers.isBusinessVerified) &&
        Objects.equals(this.isEmailVerified, appUsers.isEmailVerified) &&
        Objects.equals(this.phoneCountryCode, appUsers.phoneCountryCode) &&
        Objects.equals(this.phoneNumber, appUsers.phoneNumber) &&
        Objects.equals(this.status, appUsers.status) &&
        Objects.equals(this.userRole, appUsers.userRole) &&
        Objects.equals(this.userUuid, appUsers.userUuid) &&
        Objects.equals(this.verifiedById, appUsers.verifiedById) &&
        Objects.equals(this.dateCreated, appUsers.dateCreated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(businessCategory, businessDesc, name, businessRegNumber, businessType, email, isBusinessVerified, isEmailVerified, phoneCountryCode, phoneNumber, status, userRole, userUuid, verifiedById, dateCreated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppUsers {\n");
    sb.append("    businessCategory: ").append(toIndentedString(businessCategory)).append("\n");
    sb.append("    businessDesc: ").append(toIndentedString(businessDesc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    businessRegNumber: ").append(toIndentedString(businessRegNumber)).append("\n");
    sb.append("    businessType: ").append(toIndentedString(businessType)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isBusinessVerified: ").append(toIndentedString(isBusinessVerified)).append("\n");
    sb.append("    isEmailVerified: ").append(toIndentedString(isEmailVerified)).append("\n");
    sb.append("    phoneCountryCode: ").append(toIndentedString(phoneCountryCode)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userRole: ").append(toIndentedString(userRole)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
    sb.append("    verifiedById: ").append(toIndentedString(verifiedById)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

