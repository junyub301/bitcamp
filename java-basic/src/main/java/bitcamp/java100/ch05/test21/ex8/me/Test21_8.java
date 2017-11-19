package bitcamp.java100.ch05.test21.ex8.me;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8 {

    static class Member {
        String name;
        String email;
        String phone;

        String save() {

            return String.format("%s\t%s %s",this.name, this.email, this.phone);
        }    

    }

    public static void main(String[] args){


        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }

        Member m = new Member();
        ArrayList<String> list = new ArrayList<>();


        while (true) {
            m.name = console.readLine("이름? ");
            m.email = console.readLine("이메일? ");
            m.phone = console.readLine("전화? ");
            if (console.readLine("저장하시겠습니까?(y/n) ").equals("y"))
            {
                System.out.println("저장하였습니다.");
                list.add(m.save());
            }
            else {
                System.out.println("저장을 취소하였습니다.");
            }
            if (console.readLine("계속 하시겠습니까?(y/n) ").equals("y")) {
                continue;
            }
            else {
                System.out.println("--------------------------");
                for (String n : list) {
                    System.out.println(n);
                }
            }

            break;
        }

    }

}







