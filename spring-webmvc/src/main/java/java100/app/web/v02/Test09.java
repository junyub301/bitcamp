package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test09") 
public class Test09 {
    
    // 테스트 방법
    //      http://localhost:9999/spring-webmvc/v02/test09.html

    
    // GET/POST/DELETE 등을 구분하는 또 다른 방법
    // 
    //@RequestMapping(method=RequestMethod.GET)
    @GetMapping // 위의 애노테이션과 같은 의미이다.
    public String get() {
        System.out.println("get()");
        return "/hello.jsp";
    }

    //@RequestMapping(method=RequestMethod.POST)
    @PostMapping // 위의 애노테이션과 같은 의미이다.
    public String post() {
        System.out.println("post()");
        return "/hello.jsp";
    }

    // 그 밖의 콘텐츠 타입일 경우
    @RequestMapping
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }
    
}
