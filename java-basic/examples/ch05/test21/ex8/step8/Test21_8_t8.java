package bitcamp.java100.test21.ex8.step8;

import java.io.Console;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
public class Test21_8_t8 {
    
    static Console console;

    static void printContacts() {
        for(int i = 0; i < ContactArray.size(); i++) { 
            Contact contact = ContactArray.get(i);
            System.out.printf("%s, %s, %s\n", 
                    contact.name, 
                    contact.email, 
                    contact.tel);
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

        while (true) {

            Contact contact = inputContact();

            if (confirm("저장하시겠습니까?")) {
                try {
                ContactArray.add(contact);
                } catch (RuntimeException e) {
                    System.err.println("최대 저장 개수를 초과하였습니다.");
                    break;
                }
            }
            if (!confirm("계속입력하시겠습니까?")) 
                break;
        }
        printContacts();

    }

}


