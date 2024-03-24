package com.prokhure.erp.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.prokhure.erp.service.model.CategoryDto;
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

@Schema(name = "CategoryListResponseDto_data", description = "A list of the banks and their uuids")
@JsonTypeName("CategoryListResponseDto_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T19:59:54.291948+01:00[Africa/Lagos]")
public class CategoryListResponseDtoData {

  private PageInfo pageInfo;

  @Valid
  private List<@Valid CategoryDto> categories;

  public CategoryListResponseDtoData pageInfo(PageInfo pageInfo) {
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

  public CategoryListResponseDtoData categories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
    return this;
  }

  public CategoryListResponseDtoData addCategoriesItem(CategoryDto categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * List of users
   * @return categories
  */
  @Valid 
  @Schema(name = "categories", description = "List of users", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categories")
  public List<@Valid CategoryDto> getCategories() {
    return categories;
  }

  public void setCategories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryListResponseDtoData categoryListResponseDtoData = (CategoryListResponseDtoData) o;
    return Objects.equals(this.pageInfo, categoryListResponseDtoData.pageInfo) &&
        Objects.equals(this.categories, categoryListResponseDtoData.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageInfo, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryListResponseDtoData {\n");
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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

