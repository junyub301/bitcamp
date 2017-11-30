package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member")
public class MemberController implements Controller  {

    // 스프링 IoC 컨테이너가 DataSource 객체를 주입하도록 표시
    @Autowired
    MemberDao memberDao;

    @Override
    public void destroy() {}

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
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

        try {
            List<Member> list = memberDao.selectList();

            for (Member member : list) {
                out.printf("%4d, %-4s, %4s, %s\n",  
                        member.getNo(),
                        member.getName(),
                        member.getEmail(),
                        member.getCreatedDate()); 
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    private void doAdd(Request request, Response response) {


        PrintWriter out = response.getWriter();

        try {
            Member member = new Member();
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPwd(request.getParameter("password"));
            
            memberDao.insert(member);
            out.println("저장하였습니다.");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doView(Request request, Response response) {

        PrintWriter out = response.getWriter();

        out.println("[회원 정보]");

        try {

            int no = Integer.parseInt(request.getParameter("no"));

            Member member = memberDao.selectOne(no);
            if (member != null) {
                
                out.printf("번호: %d\n",member.getNo());
                out.printf("이름: %s\n", member.getName());
                out.printf("이메일: %s\n", member.getEmail());
                out.printf("등록일: %s\n", member.getCreatedDate());
            } else {
                out.printf("'%s'번의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();

        try {
            Member member = new Member();
            member.setEmail(request.getParameter("email"));
            member.setName(request.getParameter("name"));
            member.setPwd(request.getParameter("password"));
            member.setNo(Integer.parseInt(request.getParameter("no")));


            // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
            if (memberDao.update(member) > 0 ) { 
                out.println("변경하였습니다..");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", member.getNo());
            }

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");
        try {
            int no = Integer.parseInt(request.getParameter("no"));

            if (memberDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

}
