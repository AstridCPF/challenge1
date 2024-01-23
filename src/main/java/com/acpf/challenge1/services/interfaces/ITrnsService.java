package com.acpf.challenge1.services.interfaces;

import com.acpf.challenge1.dto.TransactionDetailsDto;
import com.acpf.challenge1.enums.ENTrnsType;
import com.acpf.challenge1.exceptions.ChallengeDbException;
import com.acpf.challenge1.model.Transaction;
/**
 * ACPF - Challenge1 Application
 * ITrnsService
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public interface ITrnsService {
    Transaction doTransaction(TransactionDetailsDto dto) throws ChallengeDbException;
}
