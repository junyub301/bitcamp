package me.ver21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberController {

    private ArrayList<Member> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);

    public void execute() {
        loop:
            while(true) {
                System.out.print("회원관리> ");
                String input = keyScan.nextLine();

                switch (input) {
                case "add": this.doAdd(); break; //ok
                case "list": this.doList(); break; // ok
                case "view": this.doView(); break; // ok
                case "delete": this.doDelete(); break; // ok
                case "update": this.doUpdate(); break;
                case "main":; break loop;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
            } // while        
    }

    public void doUpdate() {
        System.out.println("[학생 정보 변경]");
        String email = Prompts.input("이름? ");

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
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", member);
        } else {
            member.update();
        }        
    }

    public void doDelete() {
        System.out.println("[학생 삭제]");

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

    public void doView() {
        System.out.println("[학생 정보]");
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
        } else
            member.print();        
    }

    public void doList() {

        System.out.println("[학생 목록]");
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().list();
        }

    }

    public void doAdd() {

        System.out.println("[학생 등록]");

        Member member;

        while(true) {

            member = new Member();
            member.input();

            Member check = null;
            Iterator<Member> iterator = list.iterator();
            while (iterator.hasNext()) {
                Member temp = iterator.next();
                if(temp.email.equals(member.email)) {
                    check = temp;
                    break;
                }
            }

            if (check == null) {
                list.add(member);
            } else {
                System.out.println("이미 등록된 이메일입니다.");
                break;
            }

            if (!Prompts.confirm("계속하시겠습니까?(Y/n)"))
                break;

        }
    }


}
