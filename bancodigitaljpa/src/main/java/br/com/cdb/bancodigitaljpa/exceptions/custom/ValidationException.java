package br.com.cdb.bancodigitaljpa.exceptions.custom;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApiException {
    
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
