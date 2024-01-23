package com.acpf.challenge1.model;

import com.acpf.challenge1.enums.ENEntityType;
import com.acpf.challenge1.enums.ENEventType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
/**
 * ACPF - Challenge1 Application
 * Event
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Document
public class Event {

    @Id
    private String _id;

    private ENEventType eventType;

    private ENEntityType entityType;

    private LocalDateTime eventTime;

    private Account account;

    private Transaction transaction;

    public Event() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ENEventType getEventType() {
        return eventType;
    }

    public void setEventType(ENEventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public ENEntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(ENEntityType entityType) {
        this.entityType = entityType;
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

    @Override
    public String toString() {
        return "Event{" +
                "_id='" + _id + '\'' +
                ", eventType=" + eventType +
                ", entityType=" + entityType +
                ", eventTime=" + eventTime +
                ", account=" + account +
                ", transaction=" + transaction +
                '}';
    }
}
