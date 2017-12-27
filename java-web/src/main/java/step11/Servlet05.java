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
@WebServlet("/step11/Servlet05")
public class Servlet05 extends HttpServlet {

    // 테스트 방법 : 
    // 1) 웹 브라우저를 모두 닫아라! 그러면 Servlet01에서 보낸 쿠키 데이터가 지워진다.
    // 2) 웹 브라우저를 새로 띄우고 쿠키가 없음을 확인하라 
    //     - Servlet02~04 요청
    // 3)/step11/Servlet05를 요청하라!
    //     - 사용범위가 정해진 쿠키를 받아서 보관한다.
    // 4) Servlet02~04를 실행하여 출력되는 쿠키데이터를 확인하라.
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 기본 경로
        // 즉 /step11/* 서블릿만 name을 받을 수 있다.
        res.addCookie(new Cookie("name", "hong"));
        
        // 모든 경로의 서블릿들이 쿠키를 받을 수 있도록 조정하기
        Cookie cookie = new Cookie("age", "20");
        cookie.setPath("/");

        res.addCookie(cookie);
        
        // 특정 경로(/java-web/other)의 서블릿만이 쿠키를 받을 수 있도록 설정하기
        cookie = new Cookie("working", "true");
        cookie.setPath("/java-web/other");
        res.addCookie(cookie);


        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
    }

}









