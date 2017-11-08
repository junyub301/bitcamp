package bitcamp.java100.ch13.ex6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();

        try {
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
        } finally {
            // finally 블록은 try 블록을 나가기 전에 반드시 실행한다.
            System.out.println("finally 블록 실행!");
        }
    }

}
