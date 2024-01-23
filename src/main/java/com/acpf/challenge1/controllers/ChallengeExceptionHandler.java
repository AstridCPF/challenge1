package com.acpf.challenge1.controllers;

import com.acpf.challenge1.dto.GenericDto;
import com.acpf.challenge1.exceptions.Challenge1BusinessException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * ACPF - Challenge1 Application
 * ChallengeExceptionHandler
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ChallengeExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Manejo global de excepción Challenge1BusinessException
     * @param ex
     * @return
     */
    @ExceptionHandler(Challenge1BusinessException.class)
    protected ResponseEntity<Object> handleChallenge1BusinessException(
            Challenge1BusinessException ex) {
        int code = ex.getCode();
        String error = "Error: " + ex.getMessage();
        GenericDto gdto = new GenericDto(code, error);
        gdto.setHttpStatus(HttpStatus.NOT_FOUND);
        return buildResponseEntity(gdto);
    }

    private ResponseEntity<Object> buildResponseEntity(GenericDto genericDto) {
        return new ResponseEntity<>(genericDto , genericDto.getHttpStatus());
    }

}
