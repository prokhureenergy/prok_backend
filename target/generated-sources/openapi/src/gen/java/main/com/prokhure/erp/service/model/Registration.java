package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Registration
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T13:46:26.923943+01:00[Africa/Lagos]")
public class Registration {

  private String firstName;

  private String lastName;

  private String businessName;

  private String businessRegistrationNumber;

  private String email;

  private String phoneCountryCode;

  private String phoneNumber;

  private String password;

  /**
   * user role
   */
  public enum RoleEnum {
    VENDOR("vendor"),
    
    ADMIN("admin"),
    
    SPONSOR("sponsor"),
    
    ORGANIZATION("organization"),
    
    CUSTOMER("customer");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private RoleEnum role;

  private String roleType;

  public Registration firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The users firstname
   * @return firstName
  */
  @Pattern(regexp = "^[a-zA-Z- '()]{2,50}$") 
  @Schema(name = "firstName", example = "mike", description = "The users firstname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Registration lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The users lastName
   * @return lastName
  */
  @Pattern(regexp = "^[a-zA-Z- '()]{2,50}$") 
  @Schema(name = "lastName", example = "mike", description = "The users lastName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Registration businessName(String businessName) {
    this.businessName = businessName;
    return this;
  }

  /**
   * The users business name
   * @return businessName
  */
  @Pattern(regexp = "^[a-zA-Z-0-9 '()]{2,250}$") 
  @Schema(name = "businessName", example = "mike holdings", description = "The users business name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessName")
  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public Registration businessRegistrationNumber(String businessRegistrationNumber) {
    this.businessRegistrationNumber = businessRegistrationNumber;
    return this;
  }

  /**
   * business reg number e.g RC or CAC number
   * @return businessRegistrationNumber
  */
  @Pattern(regexp = "^[a-zA-Z-0-9]{1,100}$") 
  @Schema(name = "businessRegistrationNumber", example = "653518", description = "business reg number e.g RC or CAC number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessRegistrationNumber")
  public String getBusinessRegistrationNumber() {
    return businessRegistrationNumber;
  }

  public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
    this.businessRegistrationNumber = businessRegistrationNumber;
  }

  public Registration email(String email) {
    this.email = email;
    return this;
  }

  /**
   * users email address
   * @return email
  */
  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") @jakarta.validation.constraints.Email
  @Schema(name = "email", description = "users email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Registration phoneCountryCode(String phoneCountryCode) {
    this.phoneCountryCode = phoneCountryCode;
    return this;
  }

  /**
   * International country phone code
   * @return phoneCountryCode
  */
  @Pattern(regexp = "^[0-9]{1,3}$") 
  @Schema(name = "phoneCountryCode", description = "International country phone code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneCountryCode")
  public String getPhoneCountryCode() {
    return phoneCountryCode;
  }

  public void setPhoneCountryCode(String phoneCountryCode) {
    this.phoneCountryCode = phoneCountryCode;
  }

  public Registration phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Users phone number
   * @return phoneNumber
  */
  @Pattern(regexp = "^[0-9- ()]{6,30}$") 
  @Schema(name = "phoneNumber", description = "Users phone number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Registration password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User's new password
   * @return password
  */
  
  @Schema(name = "password", description = "User's new password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Registration role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * user role
   * @return role
  */
  
  @Schema(name = "role", example = "vendor, admin, sponsor, organization, customer", description = "user role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public Registration roleType(String roleType) {
    this.roleType = roleType;
    return this;
  }

  /**
   * user role type
   * @return roleType
  */
  
  @Schema(name = "roleType", example = "example vendor has company and indivdual", description = "user role type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("roleType")
  public String getRoleType() {
    return roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Registration registration = (Registration) o;
    return Objects.equals(this.firstName, registration.firstName) &&
        Objects.equals(this.lastName, registration.lastName) &&
        Objects.equals(this.businessName, registration.businessName) &&
        Objects.equals(this.businessRegistrationNumber, registration.businessRegistrationNumber) &&
        Objects.equals(this.email, registration.email) &&
        Objects.equals(this.phoneCountryCode, registration.phoneCountryCode) &&
        Objects.equals(this.phoneNumber, registration.phoneNumber) &&
        Objects.equals(this.password, registration.password) &&
        Objects.equals(this.role, registration.role) &&
        Objects.equals(this.roleType, registration.roleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, businessName, businessRegistrationNumber, email, phoneCountryCode, phoneNumber, password, role, roleType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Registration {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    businessName: ").append(toIndentedString(businessName)).append("\n");
    sb.append("    businessRegistrationNumber: ").append(toIndentedString(businessRegistrationNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneCountryCode: ").append(toIndentedString(phoneCountryCode)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    roleType: ").append(toIndentedString(roleType)).append("\n");
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

