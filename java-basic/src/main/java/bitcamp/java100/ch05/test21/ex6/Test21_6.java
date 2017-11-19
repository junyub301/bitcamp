package bitcamp.java100.ch05.test21.ex6;

import java.io.Console;
import java.util.Scanner;

public class Test21_6 {


    public static void main(String[] args){


        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }

        long value = Long.parseLong(console.readLine("숫자? "));
        int[] cnt = new int[10];

        while (value > 0) {
            cnt[(int)(value % 10)]++;
            value /= 10;
        }
        int b = 0;

        while (b < cnt.length) {
            System.out.printf("%d = %d\n", b, cnt[b]);
            b++;
        }


    }

}