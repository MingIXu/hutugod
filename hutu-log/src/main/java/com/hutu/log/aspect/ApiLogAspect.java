package com.hutu.log.aspect;

import com.hutu.log.annotation.ApiLog;
import com.hutu.log.event.ApiLogPublisher;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 系统日志，切面处理类
 *
 * @author hutu
 * @date 2018/6/10 15:12
 */
@Slf4j
@Aspect
public class ApiLogAspect {

    @SneakyThrows
    @Around("@annotation(apiLog)")
    public Object around(ProceedingJoinPoint point, ApiLog apiLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        Long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = point.proceed();
        } catch (Exception e) {
            log.error("访问接口报错，无日志信息记录！");
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            long spendTime = endTime - startTime;
            //记录日志
            ApiLogPublisher.publishEvent(strMethodName, strClassName, apiLog, startTime, spendTime, point.getArgs(), result);
        }
        return result;
    }

}
