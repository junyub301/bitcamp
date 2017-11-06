package java100.app.control;

import java.util.Iterator;

import java100.app.domain.Member;
import java100.app.util.Prompts;

public class MemberController extends GenericController<Member>  {

    @Override
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
            Member member = iterator.next();
            System.out.printf("%-4s,%s\n",  
                    member.getName(), 
                    member.getEmail());
        }

    }

    private void doAdd() {

        System.out.println("[회원 등록]");

        Member member;

        member = new Member();
        member.setEmail(Prompts.inputString("이메일? "));
        if (findByEmail(member.getEmail()) != null) {
            System.out.println("이미 등록된 이메일 입니다");
            return;
        } 
        member.setName(Prompts.inputString("이름? "));
        member.setPwd(Prompts.inputString("암호? "));

        list.add(member);
    }

    private void doView() {
        System.out.println("[회원 정보]");
        String email = Prompts.inputString("이메일? ");

        Member member = findByEmail(email);

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        } 
        System.out.printf("이름: %s\n이메일: %s\n암호: %s\n",  
                member.getName(),
                member.getEmail(),
                member.getPwd());      
    }

    private void doUpdate() {
        System.out.println("[성적 삭제]");
        String email = Prompts.inputString("이메일? ");

        Member member = findByEmail(email);

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }

        String name = Prompts.inputString("이름?(%s) ", member.getName());
        if (name.isEmpty()) {
            name = member.getName();
        }

        String pwd = Prompts.inputString("암호?");
        if (pwd.isEmpty()) {
            pwd = member.getPwd();
        }

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            member.setName(name);
            member.setPwd(pwd);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경 취소하였습니다.");
        }      
    }

    private void doDelete() {
        System.out.println("[성적 삭제]");
        String email = Prompts.inputString("이메일? ");

        Member member = findByEmail(email);

        if (member == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", email);
            return;
        } 
        if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
            list.remove(member);
            System.out.println("삭제했습니다.");
        } else System.out.println("삭제 취소했습니다.");

    }

    private Member findByEmail(String email) {
        Iterator<Member> iterator = list.iterator();

        while (iterator.hasNext()) {
            Member member = iterator.next();
            if(member.getEmail().equals(email)) {
                return member;
            }
        }//while
        return null;
    }
}
