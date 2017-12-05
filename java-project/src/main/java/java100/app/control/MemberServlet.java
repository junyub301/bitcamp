package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.AppInitServlet;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@WebServlet(urlPatterns="/member/*")
public class MemberServlet implements Servlet {

    ServletConfig servletConfig;
    
    MemberDao memberDao;

    @Override
    public void destroy() {}

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        memberDao = AppInitServlet.iocContainer.getBean(MemberDao.class);

    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "회원관리 서블릿";
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setContentType("text/plain;charset=UTF-8");
        
        switch (httpRequest.getPathInfo()) {
        case "/add": this.doAdd(httpRequest, httpResponse); break;
        case "/list": this.doList(httpRequest, httpResponse); break;
        case "/view": this.doView(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        case "/update": this.doUpdate(httpRequest, httpResponse); break;
        default:
            System.out.println("해당 명령이 없습니다.");
        }

        System.out.println();
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    private void doView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
