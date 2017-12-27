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
@WebServlet("/step11/Servlet02")
public class Servlet02 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 응답 헤더에 포함된 쿠키 꺼내기
        Cookie[] cookies = req.getCookies();
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("클라이언트가 보낸 쿠키!");

        if (cookies != null) { // 쿠키가 한개 이상 있다면,
            for (Cookie cookie : cookies) {
                out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
            }
        }
    }

}









