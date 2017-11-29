package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션의 보관과 사용 범위를 지정할 수 있다.
// SOURCE : 소스파일에서만 유효하고 컴파일 하면 제거된다. 즉, .class파일에 보관되지 않는다.
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation2 {}
