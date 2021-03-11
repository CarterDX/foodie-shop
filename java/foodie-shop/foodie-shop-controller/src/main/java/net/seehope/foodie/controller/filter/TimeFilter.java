package net.seehope.foodie.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(TimeFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();

		HttpServletRequest req = (HttpServletRequest) request;

		log.info("timefilter start at " + start);

		chain.doFilter(request, response);

		long end = System.currentTimeMillis();

		log.info(req.getRequestURI() + " timefilter end at " + end + " cost: " + (end - start));

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {

	}

}
