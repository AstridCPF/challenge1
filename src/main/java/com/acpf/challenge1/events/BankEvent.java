package com.acpf.challenge1.events;

import com.acpf.challenge1.model.Account;
import com.acpf.challenge1.model.Transaction;
/**
 * ACPF - Challenge1 Application
 * BankEvent
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class BankEvent {

    private Account account;

    private Transaction transaction;

    public BankEvent() {
    }

    public BankEvent(Account account) {
        this.account = account;
    }

    public BankEvent(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
