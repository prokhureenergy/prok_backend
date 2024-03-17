package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.prokhure.erp.service.model.AppUsers;
import com.prokhure.erp.service.model.PageInfo;
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
 * A list of the banks and their uuids
 */

@Schema(name = "UsersListResponse_data", description = "A list of the banks and their uuids")
@JsonTypeName("UsersListResponse_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T23:09:50.502328+01:00[Africa/Lagos]")
public class UsersListResponseData {

  private PageInfo pageInfo;

  @Valid
  private List<@Valid AppUsers> users;

  public UsersListResponseData pageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
    return this;
  }

  /**
   * Get pageInfo
   * @return pageInfo
  */
  @Valid 
  @Schema(name = "pageInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageInfo")
  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  public UsersListResponseData users(List<@Valid AppUsers> users) {
    this.users = users;
    return this;
  }

  public UsersListResponseData addUsersItem(AppUsers usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * List of users
   * @return users
  */
  @Valid 
  @Schema(name = "users", description = "List of users", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("users")
  public List<@Valid AppUsers> getUsers() {
    return users;
  }

  public void setUsers(List<@Valid AppUsers> users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersListResponseData usersListResponseData = (UsersListResponseData) o;
    return Objects.equals(this.pageInfo, usersListResponseData.pageInfo) &&
        Objects.equals(this.users, usersListResponseData.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageInfo, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersListResponseData {\n");
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

