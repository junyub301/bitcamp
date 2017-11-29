package java100.app.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 이 애노테이션은 자동으로 객체를 생성해야하는 클래스에 대해 붙인다.

// 이 애노테이션은 프로그램을 실행하는 중에 조회해야 하기 때문에 RUNTIME 유지 정책으로 설정한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    String value() default "";
    
}
