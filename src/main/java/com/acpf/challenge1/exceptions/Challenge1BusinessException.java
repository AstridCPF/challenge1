package com.acpf.challenge1.exceptions;
/**
 * ACPF - Challenge1 Application
 * Challenge1BusinessException
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
public class Challenge1BusinessException extends Exception{

    private int code;

    private String message;

    public Challenge1BusinessException(String message) {
        super(message);
    }

    public Challenge1BusinessException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
