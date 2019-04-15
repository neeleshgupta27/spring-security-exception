package com.neel.config.exception;

import java.util.Objects;
import java.util.UUID;

public class ApplicationRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private UUID exceptionId;
	private Enum<? extends ExceptionCode> exceptionCode;
	private String[] messageParams;
	
	private void init(Enum<? extends ExceptionCode> exceptionCode) {
		exceptionId = UUID.randomUUID();
		this.exceptionCode = exceptionCode;
	}

	public ApplicationRuntimeException(Enum<? extends ExceptionCode> exceptionCode) {
		super();
		init(exceptionCode);
	}

	public ApplicationRuntimeException(Enum<? extends ExceptionCode> exceptionCode, String message) {
		super(message);
		init(exceptionCode);
	}
	
	public ApplicationRuntimeException(Enum<? extends ExceptionCode> exceptionCode, String message, Throwable cause) {
		super(message, cause);
		init(exceptionCode);
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

	public String[] getMessageParams() {
		return messageParams;
	}

	public void setMessageParams(String[] messageParams) {
		this.messageParams = messageParams;
	}
	
	public void addMessageParams(Object... params) {
		messageParams = new String[params.length];
		for(int i=0; i<params.length;i++) {
			messageParams[i] = Objects.toString(params[i]);
		}
	}
	
	
}
