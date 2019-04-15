package com.neel.config.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private MessageSource messageSource;
	
	private Locale defaultLocale;

	@Autowired
	public ExceptionControllerAdvice(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(ApplicationRuntimeException.class)
	public ResponseEntity<ApplicationExceptionResponse> handleApplicationException(
			ApplicationRuntimeException exception) {

		return createResonseEntityFromApplicationRuntimeException(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<ApplicationExceptionResponse> createResonseEntityFromApplicationRuntimeException(
			ApplicationRuntimeException exception, HttpStatus httpStatus) {

		UUID exceptionId = exception.getExceptionId();
		String exceptionMessage = exception.getMessage();
		Enum<? extends ExceptionCode> exceptionCode = exception.getExceptionCode();
		String userMessage = getUserMessage(exceptionCode, exception.getMessageParams());

		ApplicationExceptionResponse applicationExceptionResponse = new ApplicationExceptionResponse(exceptionMessage,
				userMessage, exceptionId, exceptionCode);
		return createResonseEntity(applicationExceptionResponse, httpStatus);
	}

	public ResponseEntity<ApplicationExceptionResponse> createResonseEntity(
			ApplicationExceptionResponse applicationExceptionResponse, HttpStatus httpStatus) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(applicationExceptionResponse, headers, httpStatus);
	}

	private String getUserMessage(Enum<? extends ExceptionCode> exceptionCode, String[] params) {
		String message = messageSource.getMessage(exceptionCode.name(), params, this.defaultLocale);
		return params == null ? message : MessageFormat.format(message, params);
	}
	
	@Value("${application.defaultLocale}")
	public void setLocale(String localeValue) {
		this.defaultLocale = Locale.forLanguageTag(localeValue);
	}

}
