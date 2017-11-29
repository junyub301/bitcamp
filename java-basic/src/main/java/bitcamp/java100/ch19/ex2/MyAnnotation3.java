package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션의 보관과 사용 범위를 지정할 수 있다.
// CLASS : 컴파일 한 후 .class 파일에 보관된다. 단, 프로그램 실행중에는 조회할 수 없다.
// 보관정책을 지정하지 않으면 기본이 CLASS이다.
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation3 {}
