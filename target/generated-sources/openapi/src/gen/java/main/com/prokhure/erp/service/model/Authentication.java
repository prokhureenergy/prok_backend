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
 * Authentication
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class Authentication {

  private String email;

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

  public Authentication email(String email) {
    this.email = email;
    return this;
  }

  /**
   * users email address
   * @return email
  */
  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") @jakarta.validation.constraints.Email
  @Schema(name = "email", example = "xyz@mail.com", description = "users email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Authentication password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User's password
   * @return password
  */
  
  @Schema(name = "password", description = "User's password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Authentication role(RoleEnum role) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authentication authentication = (Authentication) o;
    return Objects.equals(this.email, authentication.email) &&
        Objects.equals(this.password, authentication.password) &&
        Objects.equals(this.role, authentication.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authentication {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

