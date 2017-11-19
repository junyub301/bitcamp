package bitcamp.java100.ch05.test21.ex5;

import java.io.Console;
import java.util.Scanner;

public class Test21_5_1 {

    static class ConsoleCreationException extends RuntimeException {
        // 특별히 새 기능을 추가하지 않고 이름으로 예외를 구분하기 위해 새 클래스를 만든 것.
    }

    static class InvalidGugudanException extends RuntimeException {
        // 특별히 새 기능을 추가하지 않고 이름으로 예외를 구분하기 위해 새 클래스를 만든 것.
    }

    // 클래스 변수
    static Console console; 

    static Console prepareInput() {

        console = System.console();

        if (console == null) {
            // 예외 상황을 만나면 호출자에게 알린다.
            throw new ConsoleCreationException();
        }
        return console;
    }

    static int promptGugudan() {

        int a = Integer.parseInt(console.readLine("구구단? "));

        if (a >= 10 || a == 1 || a < 0) {
            // 예외 상황을 만나면 호출자에게 알린다.
            throw new InvalidGugudanException();
        }
        return a;
    }

    static void printGugudan(int a) {

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\n", a, i, a * i);
        }
    }

    public static void main(String[] args){

        try {
            prepareInput();

            while (true) {
                int a = 0;
                try {
                    a = promptGugudan();
                    if (a == 0) break;
                    printGugudan(a);
                } catch (InvalidGugudanException e) {
                    System.err.println("구구단의 범위가 아닙니다.");
                } 
            }
            System.out.println("다시 또 오세요!");
        } catch (ConsoleCreationException e) {
            System.err.println("콘솔입력을 지원하지 않습니다.");
        }
    }
}


