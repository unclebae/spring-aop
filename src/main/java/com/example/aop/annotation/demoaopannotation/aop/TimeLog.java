package com.example.aop.annotation.demoaopannotation.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 어노테이션 인터페이스를 만든다.
 * @Target 은 어노테이션을 어디에 걸어줄지 지정하는 것이다. ElementType enum 으로 정의되어 있으며 여기에서는 METHOD 단위 어노테이션을 지정한다.
 * 만약 METHOD 로 지정해두고, 다른곳에 어노테이션을 걸어주면 컴파일 오류가 날 것이다.
 *
 * @Retention 은 이 어노테이션이 어느 시점에 동작하는지 지정하는 것이며 여기서는 JVM 실행 시점에 동작한다는 의미이다.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeLog {

}
