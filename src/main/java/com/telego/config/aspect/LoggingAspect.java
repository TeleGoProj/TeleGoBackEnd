package com.telego.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String POINTCUT = "execution(* com.telego..*(..)))";

	@Around(POINTCUT)
	public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		// Log method execution time
		logger.info("Execution time of {}.{} :: {} ms", className, methodName, stopWatch.getTotalTimeMillis());

		return result;
	}

	@AfterThrowing(pointcut = POINTCUT, throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}

	@AfterReturning(value = POINTCUT, returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint.getSignature().getName(), result);
	}

	@Before(POINTCUT)
	public void before(JoinPoint joinPoint) {
		StringBuilder parameters = new StringBuilder();
		Object[] signatureArgs = joinPoint.getArgs();

		for (Object signatureArg : signatureArgs)
			parameters.append(signatureArg);

		logger.info("Invoking {} , and parameters are {}:", joinPoint.getSignature().getName(), parameters);
	}
}
