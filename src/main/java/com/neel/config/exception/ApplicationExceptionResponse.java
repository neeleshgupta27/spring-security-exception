package com.neel.config.exception;

import java.util.UUID;

public class ApplicationExceptionResponse {

	String exceptionMessage;
	String userMessage;
	UUID exceptionId;
	private Enum<? extends ExceptionCode> exceptionCode;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public UUID getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(UUID exceptionId) {
		this.exceptionId = exceptionId;
	}

	public Enum<? extends ExceptionCode> getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Enum<? extends ExceptionCode> exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public ApplicationExceptionResponse(String exceptionMessage, String userMessage, UUID exceptionId,
			Enum<? extends ExceptionCode> exceptionCode) {
		this.exceptionMessage = exceptionMessage;
		this.userMessage = userMessage;
		this.exceptionId = exceptionId;
		this.exceptionCode = exceptionCode;
	}

}
