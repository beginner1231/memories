package com.cy.memories.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class QzoneCacheAspect {
	//private static Logger log=LoggerFactory.getLogger(SysCacheAspect.class);
    //@Pointcut("execution(* com.cy.pj.sys.service..*.find*(..))")
	@Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")//注解方式实现AOP粒度控制，方法上有@RequiredCache注解的
	public void doCachePointCut() {}
    
	@Around("doCachePointCut()")
    public Object around(ProceedingJoinPoint jp)
    		throws Throwable{
        log.info("从cache取数据");
        Object result=jp.proceed();
        log.info("将查询结果放cache");
    	return result;
    }
}
