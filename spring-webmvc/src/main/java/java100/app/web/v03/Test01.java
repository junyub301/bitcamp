package java100.app.web.v03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping("/v03/test01")
public class Test01 {

    
    // View 컴포넌트 URL을 리턴하는 경우
    // => 프론트 컨트롤러는 요청 핸들러가 리턴하는 Servlet/JSP를 실행한다.
    @RequestMapping("/m1")
    public String m1() {
        // 스프링에 기본 설정된 ViewResolver를 사용할 경우에는
        // 다음과 같이 JSP URL 정보를 정확하게 리턴하면 된다.
        // 이 방식의 문제점은 나중에 JSP 파일의 결로가 바뀌게 되면,
        // 모든 페이지 컨트롤러의 소스코드를 변경해야 하는 문제가 있다.
        // return "/hello.jsp";
        
        // 기본 ViewResolver를 다른 것으로 교체하였다면,
        // 그 리졸버의 규칙에 따라 JSP URL을 리턴해야한다.
        
        return "v03/test01/m1";
    }
    
    // 값을 리턴하지 않는 경우
    // [스프링 기본 뷰 리졸버를 사용할 경우]
    // => 실행할 뷰 컴포넌트(서블릿/JSP)의 URL이 자동으로 계산된다.
    //    view url = 현재 요청한 URL의 디렉토리이름 + 현재 요청한 URL
    // => 예) http://localhost:0000/springwebmvc/app/v02/test18/m2로 요청했다면
    //    view url = /app/v03/test01 + /app/v02/test01/m2
    //             = /app/v03/test01/app/v03/test01/m2
    // => 따라서 URL을 정확하게 명시하지 않으면 현재 URL을 기준으로 자동으로 JSP(서블릿일 수도 있다)
    //    URL을 결정하기 때문에 우리가 원하는 경로를 가리키지 못하게 된다.
    // => 해결책?
    //    스프링에 원래 설치되어 있던 "뷰를 찾아서 실행하는 객체(ViewResolver)"를
    //    다른 더 적절한 객체로 교체해야 한다.
    
    // [기본 뷰 리졸버 대신 InternalResourceViewResolver를 사용할 경우]
    // => 이 뷰 리졸버를 사용할 경우에는 view url을 리턴하지 않으면
    //    다음의 공식에 따라 view url이 결정된다.
    // => view url = prefix + 요청 핸들러의 url + postfix
    //             = / + /v03/test01/m2 + .jsp
    //             = /v03/test01/m2.jsp (앞에 이중으로 붙은 /는 제거된다.)
    
    @RequestMapping("/m2")
    public void m2() {
        System.out.println("Test01.m2()...");
    }
    
    // URL 정보를 객체에 담아서 리턴하기
    @RequestMapping("/m3")
    public View m3() {
        System.out.println("Test01.m3()...");
        
        // 다음과 같이 직접 JSP URL 경로를 View 객체에 담아 리턴할 수 있다.
        // 이런 경우 InternalResourceViewResolever를 경유하지 않는다.
        // 객체에 저장된 URL을 바로 실행한다.
        // 따라서 완전한 URL 정보를 리턴해야 한다.
        View view = new InternalResourceView("/v03/test01/m3.jsp");
        return view;
    }
    
}
