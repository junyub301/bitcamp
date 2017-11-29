package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Annotation;

public class Test1 {

    public static void main(String[] args) {
        
        Annotation[] annos = MyClass.class.getAnnotations();
        
        for (Annotation a : annos) {
            
            System.out.println(a.annotationType().getName());
        }
        
    }
}
