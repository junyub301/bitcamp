package bitcamp.java100.ch13.ex1;

import java.io.Console;

public class Test1 {

    public static void main(String[] args) {

        Console console = System.console();

        int a =Integer.parseInt(console.readLine("a? "));
        String op = console.readLine("연산자? ");
        int b =Integer.parseInt(console.readLine("b? "));

        switch (op) {
        case "+": System.out.printf("결과 = %d",a + b); break;
        case "-": System.out.printf("결과 = %d",a - b); break;
        case "*": System.out.printf("결과 = %d",a * b); break;
        case "/": System.out.printf("결과 = %d",a / b); break;
        case "%": System.out.printf("결과 = %d",a % b); break;
        default:
            System.out.println("지원하지 않는 연산자 입니다.");

        }

    }
}
