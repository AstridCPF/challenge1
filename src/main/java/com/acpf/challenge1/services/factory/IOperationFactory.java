package com.acpf.challenge1.services.factory;

import com.acpf.challenge1.exceptions.BalanceMismatchException;
import com.acpf.challenge1.model.PojoTemp;
/**
 * ACPF - Challenge1 Application
 * IOperationFactory
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public interface IOperationFactory {
    PojoTemp operation(Double n1, Double n2) throws BalanceMismatchException;
}
