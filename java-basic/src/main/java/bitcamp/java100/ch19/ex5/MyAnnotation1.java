package bitcamp.java100.ch19.ex5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션을 사용할 떄 값을 저장할 수 있다.
// 애노테이션 프로퍼티를 정의

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    
    
    String[] name();
    int[] age();
}
