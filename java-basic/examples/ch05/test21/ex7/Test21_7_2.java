// ## 키보드로부터 입력 받기 - 연습3
// - 다음과 같이 사용자로부터 문자(숫자와 알파벳)를 입력 받아 꺼꾸로 변경하시오!
// - 실행 예) 
// 문자열? AB2CTT980
// 입력한 값: AB2CTT980
// 꺼꾸로 바꾼 값: 089TTC2BA
// > 

package bitcamp.java100.test21.ex7;

import java.io.Console;

public class Test21_7_2 {

    static Console console; 
    static void preparConsole() {

        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }

    static String inputString() {
        return console.readLine("문자열? ");
    }

    static String reverseString(String str) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(str);

        for (int left = 0, right = buf.length() - 1; left < buf.length() / 2; left++, right--) {
            char ch = buf.charAt(left);
            buf.setCharAt(left, buf.charAt(right));
            buf.setCharAt(right, ch);
        }
        return buf.toString();
    }
    

    public static void main(String[] args){


        preparConsole();
        
        String str = inputString();
        String str2 = reverseString(str);
        
        
        System.out.printf("입력 문자열: %s\n", str);
        System.out.printf("변경 문자열: %s\n", str2);
    }


}

