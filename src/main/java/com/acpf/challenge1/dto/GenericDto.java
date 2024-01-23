package com.acpf.challenge1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
/**
 * ACPF - Challenge1 Application
 * GenericDto
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericDto {
    private int code;
    private String message;

    private HttpStatus httpStatus;

    public GenericDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "GenericDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
