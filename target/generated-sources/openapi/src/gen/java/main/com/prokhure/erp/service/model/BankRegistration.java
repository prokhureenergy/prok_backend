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
 * BankRegistration
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T13:46:26.923943+01:00[Africa/Lagos]")
public class BankRegistration {

  private UUID partyId;

  private String bankName;

  private String accountNumber;

  private UUID bankId;

  public BankRegistration partyId(UUID partyId) {
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

  public BankRegistration bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * bank uuid is sent to the backend
   * @return bankName
  */
  
  @Schema(name = "bankName", example = "123e4567-e89b-12d3-a456-426614174000", description = "bank uuid is sent to the backend", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankName")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public BankRegistration accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * bank account number
   * @return accountNumber
  */
  @Pattern(regexp = "^[0-9]{10,17}") 
  @Schema(name = "accountNumber", example = "0123456789", description = "bank account number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountNumber")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BankRegistration bankId(UUID bankId) {
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
    BankRegistration bankRegistration = (BankRegistration) o;
    return Objects.equals(this.partyId, bankRegistration.partyId) &&
        Objects.equals(this.bankName, bankRegistration.bankName) &&
        Objects.equals(this.accountNumber, bankRegistration.accountNumber) &&
        Objects.equals(this.bankId, bankRegistration.bankId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, bankName, accountNumber, bankId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankRegistration {\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
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

