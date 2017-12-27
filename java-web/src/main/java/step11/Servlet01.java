package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet01")
public class Servlet01 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 클라이언트에게 보낼 쿠키 준비
        Cookie cookie = new Cookie("name", "hong");

        // 응답 헤더에 추가
        res.addCookie(cookie);

        res.addCookie(new Cookie("age", "20"));
        res.addCookie(new Cookie("working", "true"));


        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
    }

}









