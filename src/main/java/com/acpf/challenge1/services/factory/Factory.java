package com.acpf.challenge1.services.factory;

import com.acpf.challenge1.enums.ENTrnsType;
import com.acpf.challenge1.services.AccountServiceImpl;

import java.util.logging.Logger;
/**
 * ACPF - Challenge1 Application
 * Factory
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class Factory {

    private static final Logger logger = Logger.getLogger(Factory.class.getName());


    public static IOperationFactory operate(ENTrnsType type) {
        switch (type){
            case WITHDRAW -> {
                return new Withdraw();
            }
            case DEPOSIT -> {
                return new Deposit();
            }
            default -> {
                logger.info("Enter transaction type");
                return null;}
        }
    }

}
