package com.neel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neel.config.exception.ExceptionCodeEnum;

@RestController
@RequestMapping(value ="/person") 
public class PersonController {

	@RequestMapping(value = "/generateException", method = RequestMethod.GET)
	public void displayExceptionMessage() {
		
		ExceptionCodeEnum.DIVIDE_BY_ZERO.throwMe("Number divided by zero.");
	}
		
	
}
