package com.acpf.challenge1.services.factory;

import com.acpf.challenge1.enums.ENStatusTrns;
import com.acpf.challenge1.exceptions.BalanceMismatchException;
import com.acpf.challenge1.model.PojoTemp;
import com.acpf.challenge1.model.Transaction;
/**
 * ACPF - Challenge1 Application
 * Withdraw
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class Withdraw implements IOperationFactory {

    /**
     * @param balance
     * @param input
     * @return
     */
    @Override
    public PojoTemp operation(Double balance, Double input) throws BalanceMismatchException {
        Transaction tr = new Transaction();
        if(balance >= input) {
            tr.setStatus(ENStatusTrns.SUCCESSFUL);
            Double acBal = balance - input;
            return new PojoTemp(tr, acBal);
        } else {
            tr.setStatus(ENStatusTrns.REJECTED);
            throw new BalanceMismatchException("Insufficient account balance");
        }
    }
}
