package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.prokhure.erp.service.model.Error;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Errors
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T13:46:26.923943+01:00[Africa/Lagos]")
public class Errors {

  private Integer status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date timestamp;

  private String message;

  private String description;

  @Valid
  private List<@Valid Error> errorDetails;

  public Errors status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The status code of the error.
   * @return status
  */
  
  @Schema(name = "status", description = "The status code of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Errors timestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The timestamp when the error occurred.
   * @return timestamp
  */
  @Valid 
  @Schema(name = "timestamp", description = "The timestamp when the error occurred.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Errors message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The error message.
   * @return message
  */
  
  @Schema(name = "message", description = "The error message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Errors description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the error.
   * @return description
  */
  
  @Schema(name = "description", description = "A description of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Errors errorDetails(List<@Valid Error> errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  public Errors addErrorDetailsItem(Error errorDetailsItem) {
    if (this.errorDetails == null) {
      this.errorDetails = new ArrayList<>();
    }
    this.errorDetails.add(errorDetailsItem);
    return this;
  }

  /**
   * Get errorDetails
   * @return errorDetails
  */
  @Valid 
  @Schema(name = "errorDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorDetails")
  public List<@Valid Error> getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(List<@Valid Error> errorDetails) {
    this.errorDetails = errorDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Errors errors = (Errors) o;
    return Objects.equals(this.status, errors.status) &&
        Objects.equals(this.timestamp, errors.timestamp) &&
        Objects.equals(this.message, errors.message) &&
        Objects.equals(this.description, errors.description) &&
        Objects.equals(this.errorDetails, errors.errorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, timestamp, message, description, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errors {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

