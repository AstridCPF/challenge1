package com.acpf.challenge1.dto;

import com.acpf.challenge1.enums.ENStatusTrns;
import com.acpf.challenge1.enums.ENTrnsType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * ACPF - Challenge1 Application
 * TransactionDetailsDto
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDetailsDto {

    private String transactionId;

    private ENStatusTrns statusTrns;

    private String accountId;

    private String accountNumber;

    private ENTrnsType type;

    private Double amount;

    public TransactionDetailsDto() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public ENStatusTrns getStatusTrns() {
        return statusTrns;
    }

    public void setStatusTrns(ENStatusTrns statusTrns) {
        this.statusTrns = statusTrns;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ENTrnsType getType() {
        return type;
    }

    public void setType(ENTrnsType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDetailsDto{" +
                "transactionId='" + transactionId + '\'' +
                ", statusTrns=" + statusTrns +
                ", accountId='" + accountId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }

    public static class Builder {

        private String transactionId;

        private String accountId;

        private String accountNumber;

        private ENStatusTrns statusTrns;

        private ENTrnsType type;

        private Double amount;

        public Builder() {
        }


        public TransactionDetailsDto.Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public TransactionDetailsDto.Builder withAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public TransactionDetailsDto.Builder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public TransactionDetailsDto.Builder withStatusTrns(ENStatusTrns statusTrns) {
            this.statusTrns = statusTrns;
            return this;
        }

        public TransactionDetailsDto.Builder withType(ENTrnsType type) {
            this.type = type;
            return this;
        }

        public TransactionDetailsDto.Builder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public TransactionDetailsDto build(){
            TransactionDetailsDto transaction = new TransactionDetailsDto();
            transaction.transactionId = this.transactionId;
            transaction.accountId = this.accountId;
            transaction.statusTrns = this.statusTrns;
            transaction.amount = this.amount;
            transaction.type = this.type;
            return transaction;
        }

    }
}
