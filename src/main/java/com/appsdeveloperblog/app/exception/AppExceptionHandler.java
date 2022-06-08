package com.appsdeveloperblog.app.exception;

import com.appsdeveloperblog.app.rest.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/06/22
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex) {

		String errorMessageDescription = ex.getLocalizedMessage();

		if (errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handleSpecificException(Exception ex) {

		String errorMessageDescription = ex.getLocalizedMessage();

		if (errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
