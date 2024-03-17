package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.prokhure.erp.service.model.AuthenticationResponseDataTokenDetail;
import com.prokhure.erp.service.model.AuthenticationResponseDataUserDetail;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The data object containing token details and user detail (string)
 */

@Schema(name = "AuthenticationResponse_data", description = "The data object containing token details and user detail (string)")
@JsonTypeName("AuthenticationResponse_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T23:09:50.502328+01:00[Africa/Lagos]")
public class AuthenticationResponseData {

  private AuthenticationResponseDataTokenDetail tokenDetail;

  private AuthenticationResponseDataUserDetail userDetail;

  public AuthenticationResponseData tokenDetail(AuthenticationResponseDataTokenDetail tokenDetail) {
    this.tokenDetail = tokenDetail;
    return this;
  }

  /**
   * Get tokenDetail
   * @return tokenDetail
  */
  @Valid 
  @Schema(name = "tokenDetail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tokenDetail")
  public AuthenticationResponseDataTokenDetail getTokenDetail() {
    return tokenDetail;
  }

  public void setTokenDetail(AuthenticationResponseDataTokenDetail tokenDetail) {
    this.tokenDetail = tokenDetail;
  }

  public AuthenticationResponseData userDetail(AuthenticationResponseDataUserDetail userDetail) {
    this.userDetail = userDetail;
    return this;
  }

  /**
   * Get userDetail
   * @return userDetail
  */
  @Valid 
  @Schema(name = "userDetail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userDetail")
  public AuthenticationResponseDataUserDetail getUserDetail() {
    return userDetail;
  }

  public void setUserDetail(AuthenticationResponseDataUserDetail userDetail) {
    this.userDetail = userDetail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResponseData authenticationResponseData = (AuthenticationResponseData) o;
    return Objects.equals(this.tokenDetail, authenticationResponseData.tokenDetail) &&
        Objects.equals(this.userDetail, authenticationResponseData.userDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenDetail, userDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResponseData {\n");
    sb.append("    tokenDetail: ").append(toIndentedString(tokenDetail)).append("\n");
    sb.append("    userDetail: ").append(toIndentedString(userDetail)).append("\n");
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

