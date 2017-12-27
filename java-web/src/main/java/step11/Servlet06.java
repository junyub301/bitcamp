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
@WebServlet("/step11/Servlet06")
public class Servlet06 extends HttpServlet {

    // 테스트 방법 : 
    // 1) 웹 브라우저를 모두 닫아라! 그러면 기존에 보낸 쿠키 데이터가 지워진다.
    // 2) 웹 브라우저를 새로 띄우고 쿠키가 없음을 확인하라 
    //     - Servlet06 요청
    // 3) 쿠키확인
    //     - Servlet02 요청
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 사용기간을 지정하지 않은 경우
        
        res.addCookie(new Cookie("name", "hong"));
        
        // 사용 기간을 30초 지정할 경우
        
        Cookie cookie = new Cookie("age", "20");
        cookie.setMaxAge(30); //30초
        res.addCookie(cookie);
        

        // 사용 기간을 1분으로 지정할 경우    
        
        cookie = new Cookie("working", "true");
        cookie.setMaxAge(60); //60초
        res.addCookie(cookie);


        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
    }

}









