package bitcamp.java100.test21.ex8.step2;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8_t2 {



    public static void main(String[] args){


        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }

        String[] names = new String[100];
        String[] emails = new String[100];
        String[] tels = new String[100];

        int cursor = 0;

        while (cursor < names.length) {
            String name = console.readLine("이름? ");
            String email = console.readLine("이메일? ");
            String tel = console.readLine("전화? ");
            String response = console.readLine("저장하시겠습니까?(y/n) ");
            
            if ((response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))) {
                names[cursor] = name;
                emails[cursor] = email;
                tels[cursor] = tel;
                cursor++;
            }
            
            response = console.readLine("계속 입력하시겠습니까?(y/n) ");
            if (!(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))) 
                break;
        }

            for(int i = 0; i < cursor; i++) {   
            System.out.printf("%s, %s, %s\n", names[i], emails[i], tels[i]);
        }
    }

}







