package com.neel.config.exception;

import java.text.MessageFormat;

public enum ExceptionCodeEnum implements ExceptionCode{

	INTERNAL_ERROR,
	RECORD_ALREADY_AVAILABLE,
	DIVIDE_BY_ZERO,
	NOT_FOUND;
	
	public void throwMe(String exceptionMessage) throws ApplicationRuntimeException{
		final ApplicationRuntimeException are = new ApplicationRuntimeException(this, exceptionMessage);
		throw are;
	}
	
	public void throwMe(String exceptionMessage, Object... params) throws ApplicationRuntimeException{
		final ApplicationRuntimeException are = new ApplicationRuntimeException(this, 
								MessageFormat.format(exceptionMessage, params));
		are.addMessageParams(params);
		throw are;
	}
	
	
	
}
