package com.acpf.challenge1.services.interfaces;

import com.acpf.challenge1.dto.AccountDetailsDto;
import com.acpf.challenge1.exceptions.ChallengeDbException;
import com.acpf.challenge1.model.Account;
/**
 * ACPF - Challenge1 Application
 * IAccountService
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public interface IAccountService {

    Account createAccount(AccountDetailsDto input);
    Account getBalance(String accountId) throws ChallengeDbException;
}
