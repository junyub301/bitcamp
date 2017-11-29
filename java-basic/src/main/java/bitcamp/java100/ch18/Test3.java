package bitcamp.java100.ch18;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test3 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Z.class;
        
        // public 생성자 조회
        Constructor<?>[] constructors =  clazz.getConstructors();
        
        for (Constructor<?> con : constructors) {
            System.out.println(con.getName());
            
            Parameter[] params = con.getParameters();
            for (Parameter param : params) {
                System.out.printf("    %s:%s\n", param.getName(),param.getType().getName());
            }
        }
        
        System.out.println("----------------------------------");
        
        // 모든 생성자 조회
        constructors =  clazz.getDeclaredConstructors();
        
        for (Constructor<?> con : constructors) {
            System.out.println(con.getName());
            
            Parameter[] params = con.getParameters();
            for (Parameter param : params) {
                System.out.printf("    %s:%s\n", param.getName(),param.getType().getName());
            }
        }
    
    }
}

// z.class에는 원래 파라미터명이 저장되있다.
// -parameters를 붙이면 Reflection API에서 정식으로 파라미터명을 얻을 수 있지만 
// -parameters를 붙이지 않으면 Reflection API에서 정식으로 파라미터명을 얻을 수 없다.
// 대부분 -parameters를 붙이지 않는다.
// spring 프레임워크는 -parameters를 붙이지 않아도 파라미터명을 얻을수 있다.
