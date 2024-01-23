package com.acpf.challenge1.repositories;

import com.acpf.challenge1.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * ACPF - Challenge1 Application
 * ITrnsRepo
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Repository
public interface ITrnsRepo extends MongoRepository<Transaction, String> {
}
