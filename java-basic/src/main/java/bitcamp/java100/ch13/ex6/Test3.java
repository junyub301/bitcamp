package bitcamp.java100.ch13.ex6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
    static class MyClass implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("close() 호출됨!");
        }
        
    }

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();

        try (
                MyClass obj = new MyClass();
        ) {
            System.out.println("try 블록 실행!");

            switch (str) {
            case "a": throw new Exception();  // 예외 발생
            case "b": throw new IOException();
            case "c": throw new FileNotFoundException();
            case "d": throw new SQLException();
            }
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("catch 블록 실행!");
        } 
    }

}
