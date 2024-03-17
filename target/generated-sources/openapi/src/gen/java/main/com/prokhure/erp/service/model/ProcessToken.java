package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ProcessToken
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T23:09:50.502328+01:00[Africa/Lagos]")
public class ProcessToken {

  private UUID partyId;

  private String token;

  /**
   * Action to carry out
   */
  public enum ActionEnum {
    RESEND("resend"),
    
    VALIDATE("validate");

    private String value;

    ActionEnum(String value) {
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
    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ActionEnum action;

  public ProcessToken partyId(UUID partyId) {
    this.partyId = partyId;
    return this;
  }

  /**
   * Get partyId
   * @return partyId
  */
  @Valid 
  @Schema(name = "partyId", example = "123e4567-e89b-12d3-a456-426614174000", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partyId")
  public UUID getPartyId() {
    return partyId;
  }

  public void setPartyId(UUID partyId) {
    this.partyId = partyId;
  }

  public ProcessToken token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  */
  @Pattern(regexp = "^[0-9]{5}$") 
  @Schema(name = "token", example = "47709", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ProcessToken action(ActionEnum action) {
    this.action = action;
    return this;
  }

  /**
   * Action to carry out
   * @return action
  */
  
  @Schema(name = "action", example = "resend or validate", description = "Action to carry out", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("action")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessToken processToken = (ProcessToken) o;
    return Objects.equals(this.partyId, processToken.partyId) &&
        Objects.equals(this.token, processToken.token) &&
        Objects.equals(this.action, processToken.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, token, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessToken {\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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

