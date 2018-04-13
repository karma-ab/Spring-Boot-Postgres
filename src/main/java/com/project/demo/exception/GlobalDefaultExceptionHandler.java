package com.project.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
  public static final String DEFAULT_ERROR_VIEW = "error";

  @ExceptionHandler(value = Exception.class)
  public@ResponseBody ErrorInfo
  defaultErrorHandler(HttpServletResponse res ,HttpServletRequest req, Exception e) throws Exception {
    // If the exception is annotated with @ResponseStatus rethrow it and let
    // the framework handle it - like the OrderNotFoundException example
    // at the start of this post.
    // AnnotationUtils is a Spring Framework utility class.
   /* if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
      throw e;
*/
    // Otherwise setup and send the user to a default error-view.
	  
	  ErrorInfo obj = new ErrorInfo(res.getStatus(),e.getMessage());
  
    return obj;
  }
}
