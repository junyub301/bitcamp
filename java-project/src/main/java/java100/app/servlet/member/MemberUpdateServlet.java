package java100.app.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(MemberDao.class);
        response.setContentType("text/palin;charset=UTF-8");
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

}
