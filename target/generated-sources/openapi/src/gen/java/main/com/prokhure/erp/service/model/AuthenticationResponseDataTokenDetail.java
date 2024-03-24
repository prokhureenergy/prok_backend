package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Token details
 */

@Schema(name = "AuthenticationResponse_data_tokenDetail", description = "Token details")
@JsonTypeName("AuthenticationResponse_data_tokenDetail")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class AuthenticationResponseDataTokenDetail {

  private String token;

  private String refreshToken;

  private BigDecimal expirationTime;

  public AuthenticationResponseDataTokenDetail token(String token) {
    this.token = token;
    return this;
  }

  /**
   * jwt token
   * @return token
  */
  
  @Schema(name = "token", description = "jwt token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public AuthenticationResponseDataTokenDetail refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * refresh token
   * @return refreshToken
  */
  
  @Schema(name = "refreshToken", description = "refresh token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("refreshToken")
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public AuthenticationResponseDataTokenDetail expirationTime(BigDecimal expirationTime) {
    this.expirationTime = expirationTime;
    return this;
  }

  /**
   * refresh time
   * @return expirationTime
  */
  @Valid 
  @Schema(name = "expirationTime", description = "refresh time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expirationTime")
  public BigDecimal getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(BigDecimal expirationTime) {
    this.expirationTime = expirationTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResponseDataTokenDetail authenticationResponseDataTokenDetail = (AuthenticationResponseDataTokenDetail) o;
    return Objects.equals(this.token, authenticationResponseDataTokenDetail.token) &&
        Objects.equals(this.refreshToken, authenticationResponseDataTokenDetail.refreshToken) &&
        Objects.equals(this.expirationTime, authenticationResponseDataTokenDetail.expirationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, refreshToken, expirationTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResponseDataTokenDetail {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    expirationTime: ").append(toIndentedString(expirationTime)).append("\n");
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

