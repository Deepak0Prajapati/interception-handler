package com.Spring.Interceptor.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class generalInterceptor implements HandlerInterceptor {
	
	
	private Logger log=LoggerFactory.getLogger(generalInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("pre handle invoked...{}:{}"+request.getRequestURI(),request.getMethod());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("post handle invoked...{}:{}"+request.getRequestURI(),request.getMethod());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex!=null) {
			log.error("Error Occured!!");
		}
		log.info(" after Completion handle invoked...{}:{}"+request.getRequestURI(),request.getMethod());
	}

	
}
