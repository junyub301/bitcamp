package bitcamp.java100.test21.ex8.step4;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8_t4 {
    static Console console;
    static Contact[] contacts = new Contact[100];
    static int cursor = 0;

    static class Contact {
        String name;
        String email;
        String tel;
    }

    static void printContacts() {
        for(int i = 0; i < cursor; i++) {   
            System.out.printf("%s, %s, %s\n", 
                    contacts[i].name, 
                    contacts[i].email, 
                    contacts[i].tel);
        }
    }
    
    static boolean confirm(String message) {
        String input = console.readLine(message + "(y/n) ");
        if ((input.toLowerCase().equals("y") || input.toLowerCase().equals("yes"))) 
            return true;
        return false;
    }
    
    static Contact inputContact() {
        
        Contact contact = new Contact();
        contact.name = console.readLine("이름? ");
        contact.email = console.readLine("이메일? ");
        contact.tel = console.readLine("전화? ");

        return contact;
    }

    public static void main(String[] args){

        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }

        while (cursor < contacts.length) {
            
            Contact contact = inputContact();

            if (confirm("저장하시겠습니까?")) {
                contacts[cursor] = contact;
                cursor++;
            }
            if (!confirm("계속입력하시겠습니까?")) 
                break;
        }
        printContacts();

    }

}







