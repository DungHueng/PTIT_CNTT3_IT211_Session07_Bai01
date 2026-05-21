package re.session_07.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLoggingAspect {
    @Around("execution(* re.session_07 .services.*(..))")
    public Object logTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("log: " + methodName + " chạy trong " + (end - start) + " ms");

        return proceed;
    }
}
