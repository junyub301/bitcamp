package bitcamp.java100.ch18;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test5 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Z.class;
        
        // public 메서드 조회
        // 사용을 허락받은(상속 받은) 수퍼 클래스의 public 메서드도 포함하여 조회한다.
        // Method m = clazz.getMethod("m3", int.class,float.class); -> getMethod는 public만 찾는다.
        Method m = clazz.getDeclaredMethod("m3", int.class,float.class);
        System.out.printf("메서드명: %s\n", m.getName());
        System.out.printf("리턴 타입: %s\n", m.getReturnType().getName());
        
        // 원래의 특성을 변형시키는 옵션을 조회하기
        // 비트로 옵션의 true/false을 저장하고 있다.
        // 그래서 값을 꺼낼 때는 비트 연산자를 사용해야 한다.
        int modifiers = m.getModifiers();
        
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public 이다");
        } else if (Modifier.isProtected(modifiers)) {
            System.out.println("protected 이다");
        } else if (Modifier.isPrivate(modifiers)) {
            System.out.println("private 이다");
        }
        
        System.out.println(Modifier.toString(modifiers));
    }
}

