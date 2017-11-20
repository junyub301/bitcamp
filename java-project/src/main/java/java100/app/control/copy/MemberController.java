package java100.app.control.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import java100.app.domain.Member;
import java100.app.util.Prompts;

public class MemberController extends GenericController<Member>  {
    
    private String dataFilePath;
    
    public MemberController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }
    
    @Override
    public void destroy() {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.dataFilePath)));) {
            for (Member member : this.list) {
                out.println(member.toCSVString());
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try (BufferedReader in =  new BufferedReader(new FileReader(this.dataFilePath));) {
            String csv = null;
            while((csv =in.readLine()) != null) {
                try {
                    list.add(new Member(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void execute(Request request, Response response) {

                switch (request.getMenuPath()) {
                case "/member/add": this.doAdd(request, response); break;
                case "/member/list": this.doList(request, response); break;
                case "/member/view": this.doView(request, response); break;
                case "/member/delete": this.doDelete(request, response); break;
                case "/member/update": this.doUpdate(request, response); break;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[회원 목록]");
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            out.printf("%-4s,%s\n",  
                    member.getName(), 
                    member.getEmail());
        }

    }

    private void doAdd(Request request, Response response) {

        
        PrintWriter out = response.getWriter();
        Member member = new Member();
        
        member.setEmail(request.getParameter("email"));
        
        if (findByEmail(member.getEmail()) != null) {
            out.println("이미 등록된 이메일 입니다");
            return;
        } 
        member.setName(request.getParameter("name"));
        member.setPwd(request.getParameter("pwd"));

        list.add(member);
        out.println("저장하였습니다.");
    }

    private void doView(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        
        out.println("[회원 정보]");
        String email = request.getParameter("email");

        Member member = findByEmail(email);

        if (member == null) {
            out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        } 
        out.printf("이름: %s\n이메일: %s\n암호: %s\n",  
                member.getName(),
                member.getEmail(),
                member.getPwd());      
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        out.println("[회원 변경]");
        String email = request.getParameter("email");

        Member member = findByEmail(email);

        if (member == null) {
            out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }
        
        member.setName(request.getParameter("name"));
        member.setPwd(request.getParameter("pwd"));
            out.println("변경하였습니다.");
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");
        String email = request.getParameter("email");

        Member member = findByEmail(email);

        if (member == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", email);
            return;
        } 
            list.remove(member);
            out.println("삭제했습니다.");

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
