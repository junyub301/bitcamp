package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step12/Servlet01")
public class Servlet01 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 세션을 생성한다.
        // 시나리오 1) 요청 헤더의 쿠키 값으로 세션 아이디가 넘어오지 않았다
        //             => 새로 세션을 만들어서 리턴한다.
        //             => 물론 응답할 때 새로 만든 세션의 세션 아이디를 보낸다.
        // 시나리오 2) 요청헤더의 쿠기 값으로 세션 아이디가 넘어 왔다.
        //             => 그 세션 아이디로 기존에 생성했던 세션 객체를 찾아 리턴한다.
        //             => 이때는 응답할 때 세션아이디를 다시 보내지 않는다.
        //             => 왜? 이미 클라이언트가 알고 있지 않은가!
        // 시나리오 3) 요청 헤더의 쿠키 값으로 세션 아이디가 넘어왔는데, 세션의 유효 기간(보통 5분, 30분)이 지났다.
        //             => 새로 세션을 만들어서 리턴한다.
        //             => 물론 기존의 세션 객체를 제거한다.
        //             => 따라서 기존 세션 객체에 보관된 모든 데이터도 날아간다.
        //             => 새로 세션개게를 만들었기 때문에 응답할 때, 세션아이디를 보내야 한다.
        // 참고!
        //  => JSP 페이지로 생성한 서블릿 클래스는 내부적으로 HttpSession 객체를 준비하기 때문에
        //     JSP 페이지를 요청하면 무조건 세션 객체가 생성된다. (물론 생성되어 있으면 기존 객체를 사용한다.)
        HttpSession session = req.getSession();
        
        // HttpSession 보관소에 값을 저장한다.
        session.setAttribute("name", "홍길동");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("세션을 생성하였고 그 세션아이디 값을 쿠키로 보냈음!");
    }

}









