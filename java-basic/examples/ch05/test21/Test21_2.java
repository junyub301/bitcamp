package bitcamp.java100.test21;

import java.io.Console;
import java.util.Scanner;

public class Test21_2 {
      
   
    public static void main(String[] args){
        
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        String line = console.readLine("입력하세요: ");
        
        System.out.println(line);
        
    }
}