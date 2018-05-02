package com.project.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public @ResponseBody ErrorInfo defaultErrorHandler(HttpServletResponse res, HttpServletRequest req, Exception e)
			throws Exception {

		return new ErrorInfo(res.getStatus(), e.toString());
	}
}
