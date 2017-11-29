package bitcamp.java100.ch18;

import java.lang.reflect.Method;

public class Test8 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = X.class;
        
        // static 메서드 호출
        Method m = clazz.getMethod("m2");

        m.invoke(null);
        
        clazz.getMethod("m2",int.class).invoke(null, 100);
        
        // 인스턴스 메서드를 호출할 때 인스턴스 주소를 넘기지 않으면 예외가 발생
        // clazz.getMethod("m").invoke(null);
        
        // 인스턴스를 먼저 준비한 후 호출해야한다.
        X obj = new X();
        clazz.getMethod("m").invoke(obj);
        clazz.getMethod("m",int.class).invoke(obj,100);
        clazz.getMethod("m",int.class, String.class).invoke(obj, 100, "홍길동");
        
        
        
    }
}

