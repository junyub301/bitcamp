package bitcamp.java100.ch13.ex3;

import java.io.FileReader;

public class Test3 {

    public static void main(String[] args) {
        
        class MyClass {}
        class MyClass2 implements AutoCloseable {

            @Override
            public void close() throws Exception {
                System.out.println("close() 호출 되었음");
            }
            
        }
            
        

        try (   // 이 괄호 안에 넣을 수 있는 객체는 반드시 java.lang.AutoCloseable 규칙에 따라 만든
                // 클래스의 객체여야 한다.
                // 즉 AutoCloseable 인터페이스를 구현한 클래스는 사용가능
                // AutoClooseable 안에는 close()메서드가 있다.
                
                // MyClass obj = new MyClass(); -> 컴파일 오류 (AutoCloseable 구현체가 아님)
                MyClass2 obj = new MyClass2();
        ) {
            System.out.println("try 블록 실행!");
            int r = 20 / 0;
        }
         catch (Exception e) {
            System.out.println("catch 블록 실행!");
        }
    }
}

