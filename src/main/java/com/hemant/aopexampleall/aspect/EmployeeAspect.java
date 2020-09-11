package com.hemant.aopexampleall.aspect;

import java.time.LocalDateTime;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class EmployeeAspect {

  // @Around("execution(* com.hemant.aopexampleall.service..*(..)))")
  @Around("@annotation(LogExecutionTime)")
  public void profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

    //Get intercepted method details
    String className = methodSignature.getDeclaringType().getSimpleName();
    String methodName = methodSignature.getName();

    //Measure method execution time
    LocalDateTime st = LocalDateTime.now();
    proceedingJoinPoint.proceed();
    LocalDateTime ed = LocalDateTime.now();

    //Log method execution time
    log.info("Execution dateAndTime of " + className + "." + methodName + " " +
        "date " + st.toLocalDate() + " " + (ed.getNano() - st.getNano()) / 1000000 + " ms");
  }

  @Before("execution(* com.hemant.aopexampleall.service..beforeAdvice()))")
  public void before() {
    log.info("before()");
  }

  @After("execution(* com.hemant.aopexampleall.service..beforeAdvice()))")
  public void after() {
    log.info("after()");
  }

  @AfterThrowing("execution(* com.hemant.aopexampleall.service..getEpmThrowException())")
  public void logExceptions(JoinPoint joinPoint){
    log.info("Exception thrown in Employee Method="+joinPoint.toString());
  }

  @AfterReturning(pointcut="execution(* com.hemant.aopexampleall.service..getEpmName())", returning="returnString")
  public void getNameReturningAdvice(String returnString){
   log.error("getNameReturningAdvice executed. Returned String = "+returnString);
  }

}
