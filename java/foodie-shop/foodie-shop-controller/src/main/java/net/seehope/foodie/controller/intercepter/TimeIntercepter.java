package net.seehope.foodie.controller.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimeIntercepter implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(TimeIntercepter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long start = System.currentTimeMillis();
		log.info("TimeIntercepter strat at " + start);
		request.setAttribute("start", start);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long start = (long) request.getAttribute("start");

		long end = System.currentTimeMillis();

		log.info("TimeIntercepter end at " + end + " cost " + (end - start));

	}

}
