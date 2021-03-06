package com.example.assignment.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public @ResponseBody ExceptionJSONInfo handleIllegalArguementException
		(HttpServletRequest request, Exception ex){		
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return response;
	}
	
	@ExceptionHandler(TokenGenerationException.class)
	public @ResponseBody ExceptionJSONInfo handleTokenGenerationException
		(HttpServletRequest request, Exception ex){		
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return response;
	}
	
	@ExceptionHandler({CounterServiceException.class, TokenServiceException.class})
	public @ResponseBody ExceptionJSONInfo handleServiceException
		(HttpServletRequest request, Exception ex){		
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return response;
	}
}
