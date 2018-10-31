package com.example.aop.annotation.demoaopannotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * @Aspect 는 AOP의 Aspect 클래스로 선언하는 것이다. 이는 프로그램이 실행될때 Aspect 로 동작함을 의미한다.
 */
@Aspect
@Slf4j
@Component
public class TimeLoggingAspect {

    /**
     * "@Around" 는 어드바이스의 한 종류이다. 어드바이스는 @Before, @After, @AfterReturning, @AfterThrowing, @Around가 있다.
     *  "@Before" 는 특정 메소드가 실행되기전에 수행된다.
     *  "@After" 는 메소드가 수행되고 나서 수행된다.
     *  "@AfterReturning" 은 메소드가 모두 수행되고 결과를 반환하고 나서 수행된다.
     *  "@AfterThrowing" 은 메소드 수행결과 예외가 발생하고 예외를 던진 이후에 수행된다.
     *  "@Around" 는 프록시를 그대로 사용하는 것으로 메소드의 시작과 종료 이후에 어떠한 처리를 수행할 수 있도록 한다.
     *
     *  내부에 사용된 "@annotation(TimeLog)" 조인 포인트를 나타낸다. 여기서는 TimeLog 라는 인터페이스를 만나면 이 Aspect의 Advise 가 수행된다는 의미이다.
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(TimeLog)")
    public Object logElapsedTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();

        // 실제 메소드는 조인포인트 내에서 수행된다. 이러한 처리를 프록시 패턴이라고 한다.
        final Object proceed = joinPoint.proceed();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        String method = "";
        try {
            method = joinPoint.getSignature().toShortString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        log.info("==== TIME LOG ==== Elapsed time {} ms to process [ {} ]", timeElapsed, method);

        return proceed;
    }
}
