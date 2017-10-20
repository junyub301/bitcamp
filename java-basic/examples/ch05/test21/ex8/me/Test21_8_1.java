package bitcamp.java100.test21.ex8.me;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8_1 {

    static  ArrayList<String> list = new ArrayList<>();
    static Console console; 

    static void preparConsole() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }

    static class Member {
        String name;
        String email;
        String phone;

        String save() {
            return String.format("%s\t%s %s",this.name, this.email, this.phone);
        }    
    }

    static void inputInfomation(Member m) {
        m.name = console.readLine("이름? ");
        m.email = console.readLine("이메일? ");
        m.phone = console.readLine("전화? ");
    }

    static void checkSave(Member m) {
        if (console.readLine("저장하시겠습니까?(y/n) ").equals("y"))
        {
            System.out.println("저장하였습니다.");
            list.add(m.save());
        }
        else {
            System.out.println("저장을 취소하였습니다.");
        }
    }

    static void checkRun() {
        if (console.readLine("계속 하시겠습니까?(y/n) ").equals("y")) {}
        else throw new RuntimeException();
    }

    static void printResult() {
        System.out.println("--------------------------");
        for (String n : list) {
            System.out.println(n);
        }    
    }

    public static void main(String[] args){

        preparConsole();
        Member m = new Member();
        while (true) {
            try {
                inputInfomation(m);
                checkSave(m);
                checkRun();
            } catch (RuntimeException e) {
                printResult();
                break;
            }
        }
    }

}









