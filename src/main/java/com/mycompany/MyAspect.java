package com.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("!within(com.mycompany.MyAspect) && call(* *.*(..))")
    public void logging() {}

    @Around("logging()")
    public Object logging(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        //System.out.println("Before " + thisJoinPoint.getSignature());
        //System.out.println("After " + thisJoinPoint.getSignature());
        //System.out.println("Class: " + thisJoinPoint.getClass());
        //System.out.println("Target: " + thisJoinPoint.getTarget());
        //System.out.println("Long String: " + thisJoinPoint.toLongString());
        for(Object arg : thisJoinPoint.getArgs()) {
            //System.out.println("Argument: " + arg);
        }
        //System.out.println("Kind: " + thisJoinPoint.getKind());
        //System.out.println("Source Location: " + thisJoinPoint.getSourceLocation());
        //System.out.println("StaticPart: " + thisJoinPoint.getStaticPart());

        checkIfCallingAllowed(thisJoinPoint);

        Object ret = thisJoinPoint.proceed();
        return ret;
    }

    private void checkIfCallingAllowed(ProceedingJoinPoint thisProceedingJoinPoint) {
        if(thisProceedingJoinPoint.getSignature().toString().contains("org.apache.commons.lang3.StringUtils.isEmpty")) {
            String arg = (String)thisProceedingJoinPoint.getArgs()[0];
            if("ABCD".equalsIgnoreCase(arg)) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Your code has unapproved usage.... You wont be allowed to proceeed...");
                System.exit(0);
            }
        }

    }
}
