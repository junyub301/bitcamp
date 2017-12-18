package java100.app.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/member/view")
@SuppressWarnings("serial")
public class MemberViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(MemberDao.class);
        
        int no = Integer.parseInt(request.getParameter("no"));
        Member member = memberDao.selectOne(no); 
        
        request.setAttribute("member", member);
        
        response.setContentType("text/html; charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/member/view.jsp");
        rd.include(request, response);
    }

}
