package bitcamp.java100;

import java.io.Console;
import java.util.Scanner;

public class Test21_5 {
      
   
    public static void main(String[] args){
        

        
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
       
            while (true) {
                
                int a = Integer.parseInt(console.readLine("구구단? "));
                
                if (a >= 10 || a == 1) {
                    System.out.println("2에서 9단까지만 가능합니다.");
                    continue;
                }
                else if (a == 0) {
                    System.out.println("다음에 또 봐요!");
                    break;
                }
                for (int i = 1; i <= 9; i++) {
                    System.out.printf("%d * %d = %d\n",a, i, a * i);
                }
                    
                }
            }
        
      
}