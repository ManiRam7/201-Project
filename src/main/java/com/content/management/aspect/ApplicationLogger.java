/**
 * 
 */
package com.content.management.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author M1029673
 *
 */
@Aspect
@Component
public class ApplicationLogger {

	private final Log log = LogFactory.getLog(getClass());

	public ApplicationLogger() {
	}

	@Pointcut("execution( * com.content..*.*(..))")
	private void selectAll() {
	}

	@Before("selectAll()")
	public void logMethodAccessBefore(JoinPoint joinPoint) {
		log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	}

	@AfterReturning("selectAll()")
	public void logMethodAccessAfter(JoinPoint joinPoint) {
		log.info("***** Completed: " + joinPoint.getSignature().getName() + " *****");
	}

}
