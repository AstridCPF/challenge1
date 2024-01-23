package com.acpf.challenge1.model;

import com.acpf.challenge1.enums.ENStatusTrns;
import com.acpf.challenge1.enums.ENTrnsType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
/**
 * ACPF - Challenge1 Application
 * Transaction
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Document
public class Transaction {

    @Id
    private String _id;

    private ENTrnsType type;

    @DBRef
    private Account account;

    private Double amount;

    private LocalDateTime date;

    private ENStatusTrns status;

    public Transaction() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ENTrnsType getType() {
        return type;
    }

    public void setType(ENTrnsType type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ENStatusTrns getStatus() {
        return status;
    }

    public void setStatus(ENStatusTrns status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "_id='" + _id + '\'' +
                ", type=" + type +
                ", account=" + account +
                ", amount=" + amount +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
