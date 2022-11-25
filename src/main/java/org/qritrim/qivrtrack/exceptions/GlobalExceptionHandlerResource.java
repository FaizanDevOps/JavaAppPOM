package org.qritrim.qivrtrack.exceptions;


import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qritrim.qivrtrack.utils.QivrUtils;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandlerResource {

	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandlerResource.class);



	@ExceptionHandler(QivrException.class)
	public void handleCustomException(HttpServletResponse res, QivrException ex) throws IOException {
		logger.info("CustomException Occured. Exception Message is:- "+ex.getMessage()+". Exception stack is: "+QivrUtils.returnStackTrace(ex));
		res.sendError(ex.getCode(), ex.getMessage());
	}
/*
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(HttpServletResponse res,Exception e) throws IOException {
		res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
	}
*/

	



}

