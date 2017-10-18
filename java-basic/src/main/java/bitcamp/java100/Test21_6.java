package bitcamp.java100;

import java.io.Console;
import java.util.Scanner;

public class Test21_6 {
      
   
    public static void main(String[] args){

        
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
        int a = Integer.parseInt(console.readLine("숫자 입력: "));
        int[] cnt = new int[10];
        
        while (a > 0) {
            System.out.printf("%d ", a % 10);
            cnt[a % 10]++;
            a /= 10;
        }
        
        System.out.println();
        int b = 0;
        
        while (b < cnt.length) {
            System.out.printf("%d = %d\n", b, cnt[b]);
            b++;
        }
                    
                    
    }
      
}