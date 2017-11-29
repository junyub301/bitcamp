package bitcamp.java100.ch18;

import java.lang.reflect.Field;

public class Test6 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Z.class;

        // 수퍼 클래스의 변수를 포함하여 public 변수만 추출
        Field[] fields = clazz.getFields();
        
        for (Field f : fields) {
            System.out.printf("%s %s\n", f.getType().getName(), f.getName());
        }
        
        System.out.println("---------------------------------------------");
        
        // 해당 클래스의 모든 필드를 추출
        fields = clazz.getDeclaredFields();
        
        for (Field f : fields) {
            System.out.printf("%s %s\n", f.getType().getName(), f.getName());
        }
    }
}

