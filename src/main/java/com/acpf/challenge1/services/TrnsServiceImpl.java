package com.acpf.challenge1.services;

import com.acpf.challenge1.dto.TransactionDetailsDto;
import com.acpf.challenge1.enums.ENStatusTrns;
import com.acpf.challenge1.enums.ENTrnsType;
import com.acpf.challenge1.exceptions.BalanceMismatchException;
import com.acpf.challenge1.exceptions.ChallengeDbException;
import com.acpf.challenge1.model.Account;
import com.acpf.challenge1.model.PojoTemp;
import com.acpf.challenge1.model.Transaction;
import com.acpf.challenge1.repositories.IAccountRepo;
import com.acpf.challenge1.repositories.ITrnsRepo;
import com.acpf.challenge1.services.factory.Factory;
import com.acpf.challenge1.services.factory.IOperationFactory;
import com.acpf.challenge1.services.interfaces.ITrnsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
/**
 * ACPF - Challenge1 Application
 * TrnsServiceImpl
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Service
public class TrnsServiceImpl implements ITrnsService {

    private final IAccountRepo accountRepo;

    private final ITrnsRepo trnsRepo;

    /**
     * Dependencias inyectadas a través de constructor de la clase TrnsServiceImpl
     * @param accountRepo
     * @param trnsRepo
     */
    public TrnsServiceImpl(IAccountRepo accountRepo, ITrnsRepo trnsRepo) {
        this.accountRepo = accountRepo;
        this.trnsRepo = trnsRepo;
    }

    /**
     * Método recibe como parámetro un TransactionDetailsDto con los campos accointId, type y amount.
     * Establece primero una transacción default con los primeros datos recibidos de dto y posteriormente realiza la
     * recuperación del objeto Account de la base de datos, para extraer su balance disponible. Luego, realiza la correspondiene
     * operación matemática de acuerdo al tipo de transacción solicitada. Guarda nuevamente la entidad Account con el balance actualizado.
     * En caso de que sea un retiro y el monto de la operación sea mayor al disponible del balance, se lanza una excepción y se establece el
     * estatus de la transacción como "Rejected": el balance inicial permanecerá sin modificación al momento de guardar la entidad Transaction.
     * Si al momento de recuperar el registro de Account, no se encuentra la entidad, el método lanza la excepción ChallengeDbException.
     * En caso de que, por alguna razón no se pueda completar la operación matemática y no se pueda actualizar el balance, la transacción
     * inicial se persistirá con el estatus "Pending".
     * @param trnsDto
     * @return
     * @throws ChallengeDbException
     */
    @Override
    public Transaction doTransaction(TransactionDetailsDto trnsDto) throws ChallengeDbException {
        Account account = new Account();
        account.set_id(trnsDto.getAccountId());

        Transaction tr = setDefaultTrns(trnsDto.getType(), trnsDto.getAmount(), account);

        Optional<Account> ac = accountRepo.findById(trnsDto.getAccountId());
        if(ac.isPresent()) {
            account = ac.get();
            Double balanceDb = account.getBalance();

            IOperationFactory operationFactory = Factory.operate(trnsDto.getType());
            try {
                PojoTemp temp = operationFactory.operation(balanceDb, trnsDto.getAmount());
                double balanceUpd = temp.getBalance();
                tr = temp.getTransaction();
                account.setBalance(balanceUpd);
                accountRepo.save(account);
            } catch (BalanceMismatchException e) {
                tr.setStatus(ENStatusTrns.REJECTED);
            }
            tr.setAccount(account);
            tr.setAmount(trnsDto.getAmount());
            tr.setType(trnsDto.getType());
            tr.setDate(LocalDateTime.now());
        } else {
            throw new ChallengeDbException(HttpStatus.NOT_FOUND, "Account Id not found");
        }
        return trnsRepo.save(tr);
    }

    /**
     *
     * @param type
     * @param amount
     * @param account
     * @return
     */
    private Transaction setDefaultTrns(ENTrnsType type, Double amount, Account account) {
        Transaction tr = new Transaction();
        tr.setStatus(ENStatusTrns.PENDING);
        tr.setType(type);
        tr.setAmount(amount);
        tr.setAccount(account);
        tr.setDate(LocalDateTime.now());
        return tr;
    }

}
