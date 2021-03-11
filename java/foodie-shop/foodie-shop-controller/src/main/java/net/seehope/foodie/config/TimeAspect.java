package net.seehope.foodie.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class TimeAspect {

	private static final Logger log = LoggerFactory.getLogger(TimeAspect.class);

	@Pointcut("execution(* net.seehope..*.controller.IndexController.*(..))")
	public void timePointCut() {

	}

	@Around(value = "timePointCut()")
	public Object handleIndexController(ProceedingJoinPoint pjp) throws Throwable {

		long start = System.currentTimeMillis();
		log.info("TimeAspect start at " + start);

		Object result = pjp.proceed();

		long end = System.currentTimeMillis();

		log.info("TimeAspect end at :" + end + " cost:" + (end - start));

		return result;
	}

}
