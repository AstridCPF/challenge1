package com.acpf.challenge1.model;
/**
 * ACPF - Challenge1 Application
 * PojoTemp
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class PojoTemp {

    private Transaction transaction;

    private Double balance;

    public PojoTemp(Transaction transaction, Double balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public PojoTemp() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
