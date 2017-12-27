package java100.app.web.v03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v03/test04")
public class Test04 {

    
     @RequestMapping(value="/m1")
     // @ResponseBody // @RestController에 정의된 요청 핸들러가 일반 객체를
                      // 리턴할 때 @ResponseBody를 붙일 필요가 없다.
     public Object m1() {
         return new Member("홍길동", 20, true);
     }
    
     @RequestMapping(value="/m2", produces="text/plain; charset=UTF-8")
     // @ResponseBody // @RestController에 정의된 요청 핸들러가 일반 객체를
     // 리턴할 때 @ResponseBody를 붙일 필요가 없다.
     public Object m2() {
         return "Hello!안녕!";
     }
     
}
