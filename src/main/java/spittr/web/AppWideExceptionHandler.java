package spittr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(AppWideExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public String commonExceptionHandler() {
		
		logger.error("some error just happened.");
		
		return "error/common";
	}
	
}
