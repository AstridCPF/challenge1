package com.acpf.challenge1.services.interfaces;

import com.acpf.challenge1.enums.ENEventType;
import com.acpf.challenge1.events.BankEvent;
/**
 * ACPF - Challenge1 Application
 * IEventService
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public interface IEventService {
    void addEvent(BankEvent bankEvent, ENEventType eventType);

}
