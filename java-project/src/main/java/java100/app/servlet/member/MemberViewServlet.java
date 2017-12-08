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
@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(MemberDao.class);
        response.setContentType("text/palin;charset=UTF-8");

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


}
