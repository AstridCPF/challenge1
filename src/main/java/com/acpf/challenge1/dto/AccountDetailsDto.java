package com.acpf.challenge1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * ACPF - Challenge1 Application
 * AccountDetailsDto
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDetailsDto {
    private String accountId;
    private String accountNumber;

    private String username;

    private Double balance;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountDetailsDto{" +
                "accountId='" + accountId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static class Builder {

        private String accountId;
        private String accountNumber;

        private String username;

        private Double balance;

        public Builder() {
        }

        public Builder withAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public AccountDetailsDto build(){
            AccountDetailsDto dto = new AccountDetailsDto();
            dto.accountId = this.accountId;
            dto.accountNumber = this.accountNumber;
            dto.username = this.username;
            dto.balance = this.balance;
            return dto;
        }
    }
}
