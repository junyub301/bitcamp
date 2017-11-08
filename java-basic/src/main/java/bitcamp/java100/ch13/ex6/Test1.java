package bitcamp.java100.ch13.ex6;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();

        try {
            System.out.println("try 블록 실행!");
        } finally {
            // finally 블록은 try 블록을 나가기 전에 반드시 실행한다.
            System.out.println("finally 블록 실행!");
        }
    }

}
