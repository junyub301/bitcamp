package bitcamp.java100.ch05.test21.ex6;
import java.io.Console;
import java.util.Scanner;

public class Test21_6_3 {

    static Console console;

    static void preparConsole() {
        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }

    static StringBuffer inputNumber() {
        StringBuffer buf = new StringBuffer(console.readLine("숫자? "));

        return buf;
    }

    static int[] countNumber(StringBuffer buf) {

        int[] cnt = new int[10];

        for (int i = 0; i< buf.length(); i++) {
            cnt[buf.charAt(i) - '0']++;
        }
        return cnt;
    }

    static void printNumberCount(int[] cnt) {

        for (int i = 0; i < cnt.length; i++) {
            System.out.printf("%d = %d\n", i, cnt[i]);

        }

    }
    public static void main(String[] args){

        preparConsole();
        StringBuffer buf = inputNumber();
        int[] cnt = countNumber(buf);
        printNumberCount(cnt);

    }

}