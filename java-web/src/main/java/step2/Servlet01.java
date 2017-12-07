// Servlet 인터페이스
// - 서블릿 컨테이너가 클라이언트로부터 서블릿을 실행해달라고 요청을 받으면,
//   javax.servlet.Servlet 인터페이스에 규칙에 따라 
//   개발자가 만든 객체에 대해 메서드를 호출한다.
// - Servlet은 서블릿 컨테이너(caller)와 개발자가 만든 프로그램(callee) 
//   사이에 호출 규칙이다.
// - 따라서 서블릿 컨테이너가 실행하는 프로그램을 만드려면 
//   반드시 Servlet 인터페이스를 구현해야 한다.
// 
// Servlet 인터페이스의 메서드
// - 서블릿의 생명주기와 관련된 메서드: init(), destroy(), service()
// - 기타 관리용 메서드: getServletConfig(), getServletInfo()
//
package step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step2/Servlet01")   
public class Servlet01 extends AbstractServlet {
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step2.Servlet01.service()");
    }
    
}









