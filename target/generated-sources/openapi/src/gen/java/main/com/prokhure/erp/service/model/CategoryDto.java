package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Date;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class CategoryDto {

  private UUID categoryId;

  private String name;

  private String description;

  private String parentCategory;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date dateCreated;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date dateUpdated;

  private String createdBy;

  private String status;

  public CategoryDto categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * The unique identifier for the category
   * @return categoryId
  */
  @Valid 
  @Schema(name = "categoryId", description = "The unique identifier for the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the category
   * @return name
  */
  
  @Schema(name = "name", description = "The name of the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the category
   * @return description
  */
  
  @Schema(name = "description", description = "The description of the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CategoryDto parentCategory(String parentCategory) {
    this.parentCategory = parentCategory;
    return this;
  }

  /**
   * The parent category of the category
   * @return parentCategory
  */
  
  @Schema(name = "parentCategory", description = "The parent category of the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parentCategory")
  public String getParentCategory() {
    return parentCategory;
  }

  public void setParentCategory(String parentCategory) {
    this.parentCategory = parentCategory;
  }

  public CategoryDto dateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * The date and time when the category was created
   * @return dateCreated
  */
  @Valid 
  @Schema(name = "dateCreated", description = "The date and time when the category was created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateCreated")
  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public CategoryDto dateUpdated(Date dateUpdated) {
    this.dateUpdated = dateUpdated;
    return this;
  }

  /**
   * The date and time when the category was last updated
   * @return dateUpdated
  */
  @Valid 
  @Schema(name = "dateUpdated", description = "The date and time when the category was last updated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateUpdated")
  public Date getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(Date dateUpdated) {
    this.dateUpdated = dateUpdated;
  }

  public CategoryDto createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * The user who created the category
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "The user who created the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdBy")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public CategoryDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the category
   * @return status
  */
  
  @Schema(name = "status", description = "The status of the category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryDto categoryDto = (CategoryDto) o;
    return Objects.equals(this.categoryId, categoryDto.categoryId) &&
        Objects.equals(this.name, categoryDto.name) &&
        Objects.equals(this.description, categoryDto.description) &&
        Objects.equals(this.parentCategory, categoryDto.parentCategory) &&
        Objects.equals(this.dateCreated, categoryDto.dateCreated) &&
        Objects.equals(this.dateUpdated, categoryDto.dateUpdated) &&
        Objects.equals(this.createdBy, categoryDto.createdBy) &&
        Objects.equals(this.status, categoryDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, name, description, parentCategory, dateCreated, dateUpdated, createdBy, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDto {\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateUpdated: ").append(toIndentedString(dateUpdated)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

