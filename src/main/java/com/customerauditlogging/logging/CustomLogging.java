package com.customerauditlogging.logging;

import com.customerauditlogging.service.AuditService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class CustomLogging {


    private final AuditService auditService;

    public CustomLogging(AuditService auditService) {
        this.auditService = auditService;
    }

    @Pointcut(value = "execution(* com.customerauditlogging.controller.*(..))")
    public void allMethods() {

    }

    @Around("@annotation(ActionAnnotation)")
    public Object captureActions(ProceedingJoinPoint proceedingJoinPoint) {
        ActionAnnotation actionAnnotation = (((MethodSignature) proceedingJoinPoint.getSignature()).getMethod()
                .getAnnotation(ActionAnnotation.class));
        auditService.storeAuditLog(actionAnnotation.typeOfAction(),
                actionAnnotation.typeOfModule(), null, null, null);
        Gson gson = new Gson();
        Object[] objects = proceedingJoinPoint.getArgs();
        log.info(actionAnnotation.typeOfAction());
        return null;
    }
}
