package com.acpf.challenge1.services.factory;

import com.acpf.challenge1.enums.ENStatusTrns;
import com.acpf.challenge1.exceptions.BalanceMismatchException;
import com.acpf.challenge1.model.PojoTemp;
import com.acpf.challenge1.model.Transaction;
/**
 * ACPF - Challenge1 Application
 * Deposit
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class Deposit implements IOperationFactory{
    /**
     * @param current
     * @param input
     * @return
     */
    @Override
    public PojoTemp operation(Double current, Double input) throws BalanceMismatchException {
        Transaction tr = new Transaction();
        Double balance;
        if(input > 0) {
            tr.setStatus(ENStatusTrns.SUCCESSFUL);
            balance = current + input;
            return new PojoTemp(tr, balance);
        } else if (input == 0) {
            tr.setStatus(ENStatusTrns.REJECTED);
            return new PojoTemp(tr,current);
        } else {
            throw new BalanceMismatchException("Input amount must be higher than 0");
        }
    }
}
