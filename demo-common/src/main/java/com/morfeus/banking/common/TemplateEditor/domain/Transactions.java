package com.morfeus.banking.common.TemplateEditor.domain;

public class Transactions {

    private String id;

    private String referenceId;

    private String currency;

    private String amount;

    private String status;

    private String counterpartyName;

    private String productCode;

    private String subProductCode;

    private String valueDate;

    private String applicationDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCounterpartyName() {
    return counterpartyName;
  }

  public void setCounterpartyName(String counterpartyName) {
    this.counterpartyName = counterpartyName;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getSubProductCode() {
    return subProductCode;
  }

  public void setSubProductCode(String subProductCode) {
    this.subProductCode = subProductCode;
  }

  public String getValueDate() {
    return valueDate;
  }

  public void setValueDate(String valueDate) {
    this.valueDate = valueDate;
  }

  public String getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(String applicationDate) {
    this.applicationDate = applicationDate;
  }
}
