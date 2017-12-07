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
package step1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class Servlet03 implements javax.servlet.Servlet {
    
    // init()에서 받은 파라미터 값을 저장하는 변수
    ServletConfig config;
    
    public Servlet03() {
    }
    
    @Override   
    public void init(ServletConfig config) throws ServletException {
        
        this.config = config;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step1.Servlet03.service()");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet03 - XML 파일에 서블릿 배치 정보 등록";
    }
}









