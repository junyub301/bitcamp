package bitcamp.java100.test21.ex8.step3;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8_t3 {

    static class Contact {
        String name;
        String email;
        String tel;
    }

    public static void main(String[] args){


        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        Contact[] contacts = new Contact[100];

        int cursor = 0;

        while (cursor < contacts.length) {

            Contact contact = new Contact();
            contact.name = console.readLine("이름? ");
            contact.email = console.readLine("이메일? ");
            contact.tel = console.readLine("전화? ");
            String response = console.readLine("저장하시겠습니까?(y/n) ");

            if ((response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))) {
                contacts[cursor] = contact;
                cursor++;
            }

            response = console.readLine("계속 입력하시겠습니까?(y/n) ");
            if (!(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))) 
                break;
        }

        for(int i = 0; i < cursor; i++) {   
            System.out.printf("%s, %s, %s\n", 
                    contacts[i].name, 
                    contacts[i].email, 
                    contacts[i].tel);
        }
    }

}







