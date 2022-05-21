package com.rk3.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.rk3.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}

	@Pointcut("execution(* com.rk3.springdemo.service.*.*(..))")
	public void forServicePackage() {}

	@Pointcut("execution(* com.rk3.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {}
	
	//@Before("forAppFlow()")
	public void beforeInvoke(JoinPoint joinPoint) {
		logger.info("|>| @Before() advice START: " );
		logger.info("|>| Method: " + joinPoint.getSignature().toLongString());

		//Stream.of(joinPoint.getArgs()).forEach(arg -> logger.info(" - " + arg));
		
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			logger.info(" >  Argument: " + arg);
		}
		
		logger.info("|>| @Before() advice END: \n\n" );
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterInvoke(JoinPoint joinPoint, Object result) {
		logger.info("|>| @AfterReturning() advice START: " );
		logger.info("|>| Method: " + joinPoint.getSignature().toLongString());

		//Stream.of(joinPoint.getArgs()).forEach(arg -> logger.info(" - " + arg));
		
		//Object[] args = joinPoint.getArgs();
		//for(Object arg: args) {
		//	logger.info(" >  Argument: " + arg);
		//}
		logger.info("|>| Result: " + result);
		
		logger.info("|>| @AfterReturning() advice END: \n\n" );
	}
}
