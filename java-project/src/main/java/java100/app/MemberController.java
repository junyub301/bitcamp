package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberController {

    static Scanner keyScan = new Scanner(System.in);
    private ArrayList<Member> list = new ArrayList<>();

    public void execute() {
        loop:
            while(true) {
                System.out.print("회원관리> ");
                String input = keyScan.nextLine();

                switch (input) {
                case "add": this.doAdd(); break;
                case "list": this.doList(); break;
                case "view": this.doView(); break;
                case "delete": this.doDelete(); break;
                case "update": this.doUpdate(); break;
                case "main":; break loop;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
            } // while        
    }

    private void doList() {

        System.out.println("[회원 목록]");
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }

    }

    private void doAdd() {

        System.out.println("[회원 등록]");

        Member member;

        member = new Member();
        member.input();
        
        boolean isExist = false;
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().email.equals(member.email)) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            System.out.println("이미 등록된 이메일 입니다");
        } else
            list.add(member);
    }

    private void doView() {
        System.out.println("[회원 정보]");
        String email = Prompts.input("이메일? ");
        Member member = null;
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member temp = iterator.next();
            if(temp.email.equals(email)) {
                member = temp;
                break;
            }
        }

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else
            member.printDetail();        
    }

    private void doUpdate() {
        System.out.println("[성적 삭제]");

        String email = Prompts.input("이메일? ");
        Member member = null;
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member temp = iterator.next();
            if(temp.email.equals(email)) {
                member = temp;
                break;
            }
        }

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else
            member.update();        
    }
    
    private void doDelete() {
        System.out.println("[성적 삭제]");

        String email = Prompts.input("이메일? ");
        Member member = null;
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member temp = iterator.next();
            if(temp.email.equals(email)) {
                member = temp;
                break;
            }
        }

        if (member == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", email);
        } else {
            if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
                list.remove(member);
                System.out.println("삭제했습니다.");
            }
            else System.out.println("삭제 취소했습니다.");
        }
    }
}
