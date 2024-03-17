package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The data object containing partyId (UUID) and message (string)
 */

@Schema(name = "ResponseDto_data", description = "The data object containing partyId (UUID) and message (string)")
@JsonTypeName("ResponseDto_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T13:46:26.923943+01:00[Africa/Lagos]")
public class ResponseDtoData {

  private UUID partyId;

  private String message;

  public ResponseDtoData partyId(UUID partyId) {
    this.partyId = partyId;
    return this;
  }

  /**
   * The unique id of the user
   * @return partyId
  */
  @Valid 
  @Schema(name = "partyId", example = "123e4567-e89b-12d3-a456-426614174000", description = "The unique id of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partyId")
  public UUID getPartyId() {
    return partyId;
  }

  public void setPartyId(UUID partyId) {
    this.partyId = partyId;
  }

  public ResponseDtoData message(String message) {
    this.message = message;
    return this;
  }

  /**
   * message returned from server
   * @return message
  */
  
  @Schema(name = "message", example = "we have sent a token to xyz@mail.com", description = "message returned from server", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseDtoData responseDtoData = (ResponseDtoData) o;
    return Objects.equals(this.partyId, responseDtoData.partyId) &&
        Objects.equals(this.message, responseDtoData.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDtoData {\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

