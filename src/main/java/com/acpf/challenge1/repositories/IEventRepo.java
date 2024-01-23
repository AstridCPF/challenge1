package com.acpf.challenge1.repositories;

import com.acpf.challenge1.model.Account;
import com.acpf.challenge1.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * ACPF - Challenge1 Application
 * IEventRepo
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Repository
public interface IEventRepo extends MongoRepository<Event, String> {
}
