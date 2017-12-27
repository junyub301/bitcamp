package step11;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet08")
public class Servlet08 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 응답 헤더에 포함된 쿠키 꺼내기
        Cookie[] cookies = req.getCookies();
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("클라이언트가 보낸 쿠키!");

        if (cookies != null) { // 쿠키가 한개 이상 있다면,
            for (Cookie cookie : cookies) {
                // URL로 인코딩 되어 있는 값을 받았다면,
                // 사용하기 전에 URL 디코딩하여 언래의 값을 복원해야 한다.
                out.printf("%s=%s\n", cookie.getName(), 
                        // getValue()가 리턴한 문자열은 UTF-8 코드를 URL 인코딩 한 것이다.
                        // 그러니 이 정보를 바탕으로 원래의 유니코드 값으로 복원하라는 의미이다.
                        // 즉, URL 인코딩 문자열 => UTF-8 코드 => 2 바이트 유니코드 => String 객체로 만들어 리턴한다.
                        URLDecoder.decode(cookie.getValue(), "UTF-8"));
            }
        }
    }

}









