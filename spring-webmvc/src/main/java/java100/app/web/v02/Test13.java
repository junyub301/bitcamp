package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/v02/test13")
public class Test13 {

    // 테스트 방법
    // => http://localhost:9999/sprintwebmvc/v02/test13.html
    
    // 클라이언트가 멀티파트 형식으로 보낸 데이터를 파라미터 받기
    
    @RequestMapping
    public String fileupload(String name, int age, boolean working, MultipartFile photo) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(working);
        System.out.println(photo.getOriginalFilename());
        
        System.out.println("-----------------------");
        return "/hello.jsp";
    }
    
    
}

// 멀티파트 데이터 처리방법
//  1) apache의 commons-fileupload 라이브러리를 사용하여 처리
//      -apache commons-fileupload 라이브러리를 가져온다.
//          => mvnrepository.com에서 commons-fileupload 검색 ...
//      - 멀티파트 데이터를 처리할 객체를 스프링 IoC 컨테이너에 등록한다.
//          => app-servlet.xml에 CommonsMultipartResolver 클래스의 객체를 
//             "multipartResolver"라는 일므으로 객체를 등록한다.
//      - 요청핸들러에 파라미터 선언
//          => 파일을 받을
//