package com.acpf.challenge1.services;

import com.acpf.challenge1.enums.ENEntityType;
import com.acpf.challenge1.enums.ENEventType;
import com.acpf.challenge1.events.BankEvent;
import com.acpf.challenge1.model.Event;
import com.acpf.challenge1.repositories.IEventRepo;
import com.acpf.challenge1.services.interfaces.IEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
/**
 * ACPF - Challenge1 Application
 * EventServiceImpl
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Service
public class EventServiceImpl implements IEventService {

    private final IEventRepo eventRepo;

    public EventServiceImpl(IEventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public void addEvent(BankEvent bankEvent, ENEventType eventType) {

        Event event = new Event();
        event.setEventType(eventType);
        event.setEventTime(LocalDateTime.now());

        if(bankEvent.getAccount() != null) {
            event.setAccount(bankEvent.getAccount());
            event.setEntityType(ENEntityType.ACCOUNT);
        }
        else if (bankEvent.getTransaction() != null) {
            event.setTransaction(bankEvent.getTransaction());
            event.setEntityType(ENEntityType.TRANSACTION);
        }
        eventRepo.save(event);
    }

}
