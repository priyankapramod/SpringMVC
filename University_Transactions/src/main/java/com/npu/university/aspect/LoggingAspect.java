package com.npu.university.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/*
 * Add an Aspect class that should include Before advice, After Throwing advice, and Around advice. It
doesn’t really matter what the advice does, but use a Logger so you can tell when the advice is called.
You can test that your advice is getting called when running the application in the step above.
 */


@Aspect
//@Component("loggingAspect")
public class LoggingAspect {
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	@Before("execution(public * com.npu.university.dao.jdbc.AccountMockedDaoImpl.showAccBal(..))")
	public void onBefore(JoinPoint joinPoint){
		StringBuilder sbr = new StringBuilder();
		for(Object obj:joinPoint.getArgs()){
			sbr.append(obj);
			sbr.append("  ");
		}
		logger.info("With @Before  " + joinPoint.getClass().getName() +  " " +  joinPoint.getSignature().getName() + " arguments are " + sbr.toString());
	}
	
	
	@AfterThrowing(pointcut=("execution(public * com.npu.university.services.WellsFargoPaymentServiceImpl.makePayment(..))"),throwing = "exception")
	
	public void onAfterThrowing(JoinPoint joinPoint, Exception exception){
		StringBuilder sbr = new StringBuilder();
		for(Object obj:joinPoint.getArgs()){
			sbr.append(obj);
			sbr.append("  ");
		}
		logger.info("With @AfterThrowing  " + joinPoint.getClass().getName() +  " " +  joinPoint.getSignature().getName() + " arguments are " + sbr.toString());
	}
	
	
	@Around("execution(* com.npu.university.dao.jdbc.AccountMockedDaoImpl.showAccBal(..))")
	public Object atAroundMockedDaoShowBal(ProceedingJoinPoint joinPt) throws Throwable{
		logger.info("Starting method "+joinPt.getSignature().getName());
		Object result;
		try {
			result = joinPt.proceed();
			logger.info("Return value: "+ result);
			return result;  
		} catch (IllegalArgumentException exception) {
			logger.info("Method failed with exception: "+ exception);
			throw exception;
		}
		
		
	}
	
	

}
