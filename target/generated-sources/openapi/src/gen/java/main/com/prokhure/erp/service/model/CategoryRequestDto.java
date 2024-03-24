package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryRequestDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class CategoryRequestDto {

  private UUID categoryId;

  private String name;

  private String description;

  private String parentCategory;

  /**
   * Default constructor
   * @deprecated Use {@link CategoryRequestDto#CategoryRequestDto(String)}
   */
  @Deprecated
  public CategoryRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoryRequestDto(String name) {
    this.name = name;
  }

  public CategoryRequestDto categoryId(UUID categoryId) {
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

  public CategoryRequestDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the category
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The name of the category", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryRequestDto description(String description) {
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

  public CategoryRequestDto parentCategory(String parentCategory) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRequestDto categoryRequestDto = (CategoryRequestDto) o;
    return Objects.equals(this.categoryId, categoryRequestDto.categoryId) &&
        Objects.equals(this.name, categoryRequestDto.name) &&
        Objects.equals(this.description, categoryRequestDto.description) &&
        Objects.equals(this.parentCategory, categoryRequestDto.parentCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, name, description, parentCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRequestDto {\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
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

