package spittr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * spittr exception handler
 * @author V4TOR
 *
 */
public class SpittrHandlerExceptionResolver implements HandlerExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(SpittrHandlerExceptionResolver.class);
	
	/**
	 * handle exception
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		StringBuilder errorMessageBuilder = new StringBuilder();
		
		for(StackTraceElement element : ex.getStackTrace()) {
			errorMessageBuilder.append(element.toString() + "\r\n");
		}
		
		logger.error(errorMessageBuilder.toString());
		
		return new ModelAndView("error/500");
	}

}
