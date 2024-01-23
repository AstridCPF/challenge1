package com.acpf.challenge1.exceptions;

import org.springframework.http.HttpStatus;
/**
 * ACPF - Challenge1 Application
 * ChallengeDbException
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class ChallengeDbException extends Exception {

    private HttpStatus code;

    private String message;

    public ChallengeDbException(HttpStatus code, String message) {
        super();
        this.code = code;
        this.message = message;
    }


    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChallengeDbException(String message) {
        super (message);
    }

}
