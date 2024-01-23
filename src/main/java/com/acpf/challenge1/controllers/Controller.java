package com.acpf.challenge1.controllers;

import com.acpf.challenge1.dto.AccountDetailsDto;
import com.acpf.challenge1.dto.TransactionDetailsDto;
import com.acpf.challenge1.enums.ENEventType;
import com.acpf.challenge1.enums.ENTrnsType;
import com.acpf.challenge1.events.BankEvent;
import com.acpf.challenge1.exceptions.Challenge1BusinessException;
import com.acpf.challenge1.exceptions.Challenge1Exception;
import com.acpf.challenge1.exceptions.ChallengeDbException;
import com.acpf.challenge1.model.Account;
import com.acpf.challenge1.model.Transaction;
import com.acpf.challenge1.services.interfaces.IAccountService;
import com.acpf.challenge1.services.interfaces.IEventService;
import com.acpf.challenge1.services.interfaces.ITrnsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * ACPF - Challenge1 Application
 * Controller
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@RestController
public class Controller {

    private final IAccountService accountService;

    private final ITrnsService trnsService;

    private final IEventService eventService;

    public Controller(IAccountService accountService, ITrnsService trnsService, IEventService eventService) {
        this.accountService = accountService;
        this.trnsService = trnsService;
        this.eventService = eventService;
    }


    @PostMapping("/accounts")
    public ResponseEntity<AccountDetailsDto> createAccount(@RequestBody AccountDetailsDto accountRequest)  {
        try {
            Account account = accountService.createAccount(accountRequest);
            AccountDetailsDto.Builder accountDto = new AccountDetailsDto.Builder();
            accountDto.withAccountId(account.get_id());

            ENEventType eventType = ENEventType.CREATE_ACCOUNT;
            BankEvent event = new BankEvent(account);
            eventService.addEvent(event, eventType);

            return ResponseEntity.ok(accountDto.build());

        } catch (Exception e) {
            throw new Challenge1Exception(e.getMessage());
        }
    }

    @GetMapping("/accounts/{id}/balance")
    public ResponseEntity<AccountDetailsDto> getBalance(@PathVariable String id) throws Challenge1BusinessException {
        try {
            Account account = accountService.getBalance(id);
            AccountDetailsDto.Builder accountDto = new AccountDetailsDto.Builder();
            accountDto.withBalance(account.getBalance());

            ENEventType eventType = ENEventType.CONSULT_BALANCE;
            BankEvent event = new BankEvent(account);
            eventService.addEvent(event, eventType);

            return ResponseEntity.ok(accountDto.build());

        } catch (ChallengeDbException e) {
            throw new Challenge1BusinessException(e.getCode().value(), e.getMessage());
        }
    }

    @PostMapping("/transactions")
    public ResponseEntity<TransactionDetailsDto> doTransaction(@RequestBody TransactionDetailsDto trnsDto) throws Challenge1BusinessException {
        try {
            Transaction transaction = trnsService.doTransaction(trnsDto);
            TransactionDetailsDto.Builder transactionDto = new TransactionDetailsDto.Builder();
            transactionDto.withStatusTrns(transaction.getStatus());
            transactionDto.withTransactionId(transaction.get_id());

            ENEventType eventType = getEventType(trnsDto.getType());
            BankEvent event = new BankEvent(transaction);
            eventService.addEvent(event, eventType);

            return ResponseEntity.ok(transactionDto.build());

        } catch (ChallengeDbException e) {
            throw new Challenge1BusinessException(e.getCode().value(), e.getMessage());
        }
    }

    private ENEventType getEventType(ENTrnsType type) {

        return type.equals(ENTrnsType.DEPOSIT)
                ? ENEventType.TRANSACTION_DEPOSIT : ENEventType.TRANSACTION_WITHDRAW;
    }


}
