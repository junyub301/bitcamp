package java100.app.web.v02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test10")
public class Test10 {
    
    @RequestMapping("m1")
    public String m1() {
        // 아무것도 원하지 않으면 프론트 컨트롤러는 아무것도 넘겨주지 않는다.
        return "/hello.jsp";
    }
    
    @RequestMapping("m2")
    public String m2(HttpServletRequest request) {
        // 프론트 컨트롤러가 줄 수 있는 것을 요구하라!
        // 그러면 줄 것이다.   
        return "/hello.jsp";
    }
    
    @RequestMapping("m3")
    public String m3(HttpServletResponse response) {
        // 프론트 컨트롤러가 줄 수 있는 것을 요구하라!
        // 그러면 줄 것이다.   
        return "/hello.jsp";
    }
    
    
    
}
