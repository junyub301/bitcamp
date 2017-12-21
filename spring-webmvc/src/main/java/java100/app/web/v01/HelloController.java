package java100.app.web.v01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // <= DispatcherServlet은 이 애노테이션이 붙은 클래스의 인스턴스를 자동 생성한다.
public class HelloController {

    @RequestMapping("/hello") // <= /hello 요청에 대해 이 메소드를 실행.
    public String hello() {
        return "/hello.jsp";
    }
}
