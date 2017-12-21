package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test07") 
public class Test07 {
    
    // 테스트 방법
    //      http://localhost:9999/spring-webmvc/v02/test07.html

    
    // Content-Type이라는 요청 헤더의 MIME 타입에 따라 호출될 메서드를 구분한다.
    // => Client는 POST 방식으로 데이터를 보낼 떄 그 형식을 MIME 타입으로 알려준다.
    // => 즉 Content-Type이라는 오청헤더에 MIME 타입 정보를 설정하여 웹서버에 보낸다.
    // consumes 속성에 MIME 타입을 지정하라
    @RequestMapping(consumes="text/csv")
    public String m1() {
        System.out.println("m1()");
        return "/hello.jsp";
    }

    // aaa 헤더가 있는경우
    @RequestMapping(consumes="application/json")
    public String m2() {
        System.out.println("m2()");
        return "/hello.jsp";
    }
    
    // bbb 헤더가 있는 경우
    @RequestMapping(consumes="application/x-www-form-rlencoded")
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }

    // 그 밖의 콘텐츠 타입일 경우
    @RequestMapping
    public String m4() {
        System.out.println("m4()");
        return "/hello.jsp";
    }
    
}
