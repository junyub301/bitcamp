package java100.app.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(MemberDao.class);
        response.setContentType("text/palin;charset=UTF-8");

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


}
