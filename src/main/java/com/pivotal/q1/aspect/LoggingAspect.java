package com.pivotal.q1.aspect;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LoggingAspect {
	//	.*.*.* .any subpackage.any class.any method
	@Before ("execution(* com.pivotal.q1.dao.*.*(..))")
	public void before (JoinPoint jointPoint)	{
		Logger 		logger		= LoggerFactory.getLogger(jointPoint.getTarget().getClass());
		Signature 	signature	= jointPoint.getSignature();
		String		args		= Arrays.toString(jointPoint.getArgs());
		logger.info ("Starting " + jointPoint.getTarget().getClass().getName() + "." + 
							signature.getName() + "() with args: "+ args);
	}
	@AfterReturning ("execution(* com.pivotal.q1.dao.*.*(..))")
	public void after (JoinPoint jointPoint)	{
		Logger 		logger		= LoggerFactory.getLogger(jointPoint.getTarget().getClass());
		Signature 	signature	= jointPoint.getSignature();
		String		args		= Arrays.toString(jointPoint.getArgs());
		logger.info ("Leaving " + jointPoint.getTarget().getClass().getName() + "." + 
							signature.getName()+"()");
	}
}
