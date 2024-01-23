package com.acpf.challenge1.services;

import com.acpf.challenge1.dto.AccountDetailsDto;
import com.acpf.challenge1.exceptions.ChallengeDbException;
import com.acpf.challenge1.model.Account;
import com.acpf.challenge1.repositories.IAccountRepo;
import com.acpf.challenge1.services.interfaces.IAccountService;
import com.acpf.challenge1.services.mappers.IAccountsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;
/**
 * ACPF - Challenge1 Application
 * AccountServiceImpl
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Service
public class AccountServiceImpl implements IAccountService {

    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

    private final IAccountRepo accountRepo;

    private final IAccountsMapper accountsMapper;

    /**
     * Constructor de la clase inyecta las dependencias IAccountRepo y IAccountsMapper.
     * @param accountRepo
     * @param accountsMapper
     */
    public AccountServiceImpl(IAccountRepo accountRepo, IAccountsMapper accountsMapper) {
        this.accountRepo = accountRepo;
        this.accountsMapper = accountsMapper;
    }


    /**
     * Método para la creación de una cuenta. Recibe como parámetro un AccountDetailsDto con los campos:
     * accountNumber, username y balance.
     * @param input
     * @return
     */
    @Override
    public Account createAccount(AccountDetailsDto input) {
        Account ac = accountsMapper.dtoToAccount(input);
        return accountRepo.save(ac);
    }

    /**
     * Método para la recuperación del detalle del monto disponible del balance de una cuenta.
     * Recibe como parámetro el id de una cuenta. En caso de que no se consiga el registro en la base de datos, se lanza la excepción
     * ChallengeDbException.
     * @param accountId
     * @return
     */
    @Override
    public Account getBalance(String accountId) throws ChallengeDbException {
        Optional<Account> ac = accountRepo.findById(accountId);
        if(ac.isPresent()) {
            return ac.get();
        } else {
            throw new ChallengeDbException(HttpStatus.NOT_FOUND, "Account id not found");
        }
    }
}
