package java100.app.web.v02;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping("/v02/test17")
public class Test17 {

    // 테스트 방법:
    // => http://localhost:9999/spring-webmvc/v02/test17.html
    
    // 클라이언트가 보낸 application/json 데이터를 받아서 객체로 만들기
    @RequestMapping("/m1")
    public String m1(@RequestBody String json) {
        // JSON 문자열 ==> Map 객체
        // google-gson 라이브러리를 이용하여 처리한다.
        
        
        // json 문자열을 받아서 Map 객체로 바꿔준다.
        // 어떤 json 데이터라도 다 Map 객체로 바꿀수 있다. 
        // 숫자는 기본으로 double 타입으로 바꾼다.
        @SuppressWarnings("rawtypes")
        Map obj = new Gson().fromJson(json, Map.class);
        
        System.out.printf("name=%s\n", obj.get("name"));
        System.out.printf("age=%f\n", obj.get("age"));
        System.out.printf("tel=%s\n", obj.get("tel"));
        System.out.printf("email=%s\n", obj.get("email"));

        System.out.println("-------------------");
        return "/hello.jsp";
    }

    // JSON 문자열 ==> 특정 자바 객체

    class User {
        String name;
        int age;
        String tel;
        String email;
    }
    
    @RequestMapping("/m2")
    public String m2(@RequestBody String json) {

        User user = new Gson().fromJson(json, User.class);
        
        System.out.printf("name=%s\n", user.name);
        System.out.printf("age=%d\n", user.age);
        System.out.printf("tel=%s\n", user.tel);
        System.out.printf("email=%s\n", user.email);
        
        System.out.println("-------------------");
        return "/hello.jsp";
    }
    
    // 스프링에서 제공하는 Message Converter를 이용하여
    // JSON 문자열을 자동으로 자바 객체로 바꾸기
    // => 설정이 필요
    // => 설정 방법
    //    1) JSON 문자열을 자바 객체로 바꿔주는 변환기를 등록하기
    //       - app-servlet.xml 파일에서 RequestMappingHandlerAdapter 객체 참고!
    //    2) MVC 설정을 활성화시키는 태그나 애노테이션을 사용하여 변환기를 기본으로 등록하기
    //       - 애노테이션 예:
    //          @Configuration
    //          @EnableWebMvc
    //          public class WebConfig {...}
    //       - 태그 예:
    //          <mvc:annotation-driven/>
    // 이 예제에서는 RequestMappingHandlerAdapter에 직접 컨버터를 등록한다. 
    
    
    // 요청 핸들러의 파라미터 타입으로 nested 클래스를 사용할 때는 
    // 프런트 컨트롤러가 해당 클래스를 알 수 있도록
    // public/(default) 이면서 static 클래스로 선언해야 한다.
    // 또는 패키지 멤버 클래스로 선언하면 된다.
    // 가장 좋은 방법을 패키지 멤버 클래스를 사용하는 것이다.
    static class User2 {
        String name;
        int age;
        String tel;
        String email;
        
        // google-gson 라이브러리와 달리
        // JSON 문자열을 자바 객체로 바꿀 떄 Jackson 라이브러리는
        // 셋터 메서드를 이용한다.
        // 따라서 반드시 셋터 메서드가 있어야 한다.
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
    
    @RequestMapping(value="/m3")
    public String m3(@RequestBody User2 user) {
        
        System.out.printf("name=%s\n", user.name);
        System.out.printf("age=%d\n", user.age);
        System.out.printf("tel=%s\n", user.tel);
        System.out.printf("email=%s\n", user.email);
        
        System.out.println("-------------------");
        return "/hello.jsp";
    }

    
    // 주의!
    // => HttpMessageConverter를 등록하면 
    //    클라이언트가 보낸 데이터 중에서 "application/json"에 대해 자동 변환을 실시하기 때문에
    //    기존에 문자열을 받으려 할 경우 오류가 발생한다.
    //    m2를 테스트할 때 오류가 발행살 것이다.
    // => 문자열을 그대로 받고 싶을 경우는?
    //    서버에 데이터를 보낼 때 Content-Type 헤더의 값을
    //    text/plain으로 설정하라!
    //    또한 String을 받는 컨버터를 명시적으로 등록해야한다.
}
