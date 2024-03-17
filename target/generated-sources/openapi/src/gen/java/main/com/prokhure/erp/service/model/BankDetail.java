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
 * BankDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T15:58:53.899225+01:00[Africa/Lagos]")
public class BankDetail {

  private UUID partyId;

  private String bankName;

  private UUID userBankId;

  private UUID bankId;

  public BankDetail partyId(UUID partyId) {
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

  public BankDetail bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * bank name
   * @return bankName
  */
  
  @Schema(name = "bankName", example = "Prokhure bank", description = "bank name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankName")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public BankDetail userBankId(UUID userBankId) {
    this.userBankId = userBankId;
    return this;
  }

  /**
   * The unique id of the bank
   * @return userBankId
  */
  @Valid 
  @Schema(name = "userBankId", example = "123e4567-e89b-12d3-a456-426614174000", description = "The unique id of the bank", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userBankId")
  public UUID getUserBankId() {
    return userBankId;
  }

  public void setUserBankId(UUID userBankId) {
    this.userBankId = userBankId;
  }

  public BankDetail bankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  /**
   * The unique id of the bank
   * @return bankId
  */
  @Valid 
  @Schema(name = "bankId", example = "123e4567-e89b-12d3-a456-426614174000", description = "The unique id of the bank", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankId")
  public UUID getBankId() {
    return bankId;
  }

  public void setBankId(UUID bankId) {
    this.bankId = bankId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankDetail bankDetail = (BankDetail) o;
    return Objects.equals(this.partyId, bankDetail.partyId) &&
        Objects.equals(this.bankName, bankDetail.bankName) &&
        Objects.equals(this.userBankId, bankDetail.userBankId) &&
        Objects.equals(this.bankId, bankDetail.bankId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, bankName, userBankId, bankId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankDetail {\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    userBankId: ").append(toIndentedString(userBankId)).append("\n");
    sb.append("    bankId: ").append(toIndentedString(bankId)).append("\n");
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

