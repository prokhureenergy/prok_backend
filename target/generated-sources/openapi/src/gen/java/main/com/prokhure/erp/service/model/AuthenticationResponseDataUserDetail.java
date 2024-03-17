package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * User details
 */

@Schema(name = "AuthenticationResponse_data_userDetail", description = "User details")
@JsonTypeName("AuthenticationResponse_data_userDetail")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T23:09:50.502328+01:00[Africa/Lagos]")
public class AuthenticationResponseDataUserDetail {

  private String userId;

  private String name;

  private String email;

  private String role;

  @Valid
  private List<String> permissions;

  public AuthenticationResponseDataUserDetail userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * user id
   * @return userId
  */
  
  @Schema(name = "userId", example = "123e4567-e89b-12d3-a456-426614174000", description = "user id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public AuthenticationResponseDataUserDetail name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Logged in user name
   * @return name
  */
  
  @Schema(name = "name", example = "Mike Joe", description = "Logged in user name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AuthenticationResponseDataUserDetail email(String email) {
    this.email = email;
    return this;
  }

  /**
   * logged in user email
   * @return email
  */
  
  @Schema(name = "email", example = "xyz@mail.com", description = "logged in user email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AuthenticationResponseDataUserDetail role(String role) {
    this.role = role;
    return this;
  }

  /**
   * logged in user role
   * @return role
  */
  
  @Schema(name = "role", example = "admin", description = "logged in user role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public AuthenticationResponseDataUserDetail permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public AuthenticationResponseDataUserDetail addPermissionsItem(String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * permission assigned to user
   * @return permissions
  */
  
  @Schema(name = "permissions", example = "[\"canEditUser\",\"canAddUser\",\"canViewFinance\"]", description = "permission assigned to user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("permissions")
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResponseDataUserDetail authenticationResponseDataUserDetail = (AuthenticationResponseDataUserDetail) o;
    return Objects.equals(this.userId, authenticationResponseDataUserDetail.userId) &&
        Objects.equals(this.name, authenticationResponseDataUserDetail.name) &&
        Objects.equals(this.email, authenticationResponseDataUserDetail.email) &&
        Objects.equals(this.role, authenticationResponseDataUserDetail.role) &&
        Objects.equals(this.permissions, authenticationResponseDataUserDetail.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, email, role, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResponseDataUserDetail {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

