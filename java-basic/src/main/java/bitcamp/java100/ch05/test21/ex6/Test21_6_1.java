package bitcamp.java100.ch05.test21.ex6;
import java.io.Console;
import java.util.Scanner;

public class Test21_6_1 {

    static Console console;

    static void prepareConsole() {

        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }

    static long InputNumber() {

        return Long.parseLong(console.readLine("숫자 입력: "));
    }

    static int[] conutNumbers(long value) {
        int[] cnt = new int[10];

        while (value > 0) {
            cnt[(int)(value % 10)]++;
            value /= 10;
        }
        return cnt;
    }
    static void printNumberCount(int[] cnt) {

        int b = 0;

        while (b < cnt.length) {
            System.out.printf("%d = %d\n", b, cnt[b]);
            b++;
        }

    }
    public static void main(String[] args){

        prepareConsole();

        long value = InputNumber();
        int[] cnt = conutNumbers(value);

        printNumberCount(cnt);


    }

}