package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// RUNTIME : 컴파일 한 후 .class 파일에 보관된다. 프로그램 실행 중에 조회할 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation4 {}
