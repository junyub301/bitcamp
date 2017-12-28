package java100.app.web.v03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/v03/test08")

// Model 객체에 보관되는 값은 프론트 컨트롤러가 JSP를 실행하기 전에
// ServletRequest 보관소에 복사를 하는데,
// 다음 애노테이션에 지정된 값은 세션 보관소에도 복사한다.
@SessionAttributes({"name","age"})
public class Test08 {

    
    // 일부 값은 Model 객체를 통해 간접적으로 세션에 보관하고,
    // 일부 값은 직접 세션 객체에 보관해보자!
    @RequestMapping(value="/m1", produces="text/plain;charset=UTF-8")
    public String m1(HttpSession session, Model model) {

        // Model에 저장하면 그 값들은 ServletRequest에 자동 보관된다.
        model.addAttribute("name", "홍길동"); // 세션에도 보관된다.
        model.addAttribute("age", 20); // 세션에도 보관된다.
        model.addAttribute("working", true); // 직접 세션에 보관할 것이다.

        session.setAttribute("working", true);
        
        // 보관소에 저장된 값을 확인해보자.
        return "v03/test08/m1";
    }

    // 세션 무효화하기
    @RequestMapping(value="/m2", produces="text/plain;charset=UTF-8")
    public String m2(HttpSession session) {
        
        // invalidate()로 세션을 무효화 시킨 경우
        // => 세션을 새로 만든다.
        // => @SessionAttributes에 지정한 값을 다시 새로 만든 세션이 보관한다.
        //     (내부적으로 @SessionAttributes에 지정한 값을 
        //      별도의 메모리에 관리하기 때문데 이것이 가능하다.)
        session.invalidate();
        
        // 세션을 무효화한 후 보관소에 저장된 값을 확인해보자.
        return "v03/test08/m1";
    }
    
    // 세션 무효화하기
    @RequestMapping(value="/m3")
    public String m3(SessionStatus status) {
        
        // setComplete()을 호출하면,
        // => @SessionAttributes로 지정한 값만 제거한다.
        status.setComplete();

        // 세션을 무효화한 후 보관소에 저장된 값을 확인해보자.
        return "v03/test08/m1";
    }
    
    // 세션 무효화하기
    @RequestMapping(value="/m4")
    public String m4(HttpSession session,SessionStatus status) {
        
        session.invalidate(); // session.setAttribute()로 추가한 값 모두 제거
        status.setComplete(); // @SessionAttributes로 지정한 값 모두 제거
        
        // 세션을 무효화한 후 보관소에 저장된 값을 확인해보자.
        return "v03/test08/m1";
    }
    
}
