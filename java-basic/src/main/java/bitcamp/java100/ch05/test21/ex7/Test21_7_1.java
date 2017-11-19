// ## 키보드로부터 입력 받기 - 연습3
// - 다음과 같이 사용자로부터 문자(숫자와 알파벳)를 입력 받아 꺼꾸로 변경하시오!
// - 실행 예) 
// 문자열? AB2CTT980
// 입력한 값: AB2CTT980
// 꺼꾸로 바꾼 값: 089TTC2BA
// > 

package bitcamp.java100.ch05.test21.ex7;
import java.io.Console;

public class Test21_7_1 {

    static Console console; 
    static void preparConsole() {

        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }

    static String inputString() {
        String str = console.readLine("문자열? ");
        return str;
    }

    static void printString(String str) {
        System.out.println("입력한 값: " + str);
        System.out.print("거꾸로 바꾼 값: ");
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    public static void main(String[] args){

        preparConsole();
        String str = inputString();
        printString(str);


    }

}