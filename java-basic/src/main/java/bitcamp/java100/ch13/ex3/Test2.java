package bitcamp.java100.ch13.ex3;

import java.io.FileReader;

public class Test2 {

    public static void main(String[] args) {

        try (   // 이 괄호 안에 넣을 수 있는 객체는 반드시 java.lang.AutoCloseable 규칙에 따라 만든
                // 클래스의 객체여야 한다.
                // 즉 AutoCloseable 인터페이스를 구현한 클래스는 사용가능
                // AutoClooseable 안에는 close()메서드가 있다.
                
                FileReader in = new FileReader("./build.gradle");
                ) {
            System.out.println("파일 읽기 준비 완료!");

            int ch;
            while(true) {
                ch = in.read();
                if (ch == -1) break;
                System.out.print((char)ch);
            }
            System.out.println("-------------------------------");
        } catch (Exception e) {
            System.out.println("파일 읽기 중 오류 발생!");
        }
    }
}
