package java100.app.web.v03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v03/test09")



// @SessionAttributes({"name","age"})
// => 이 애노테이션이 없으면, 프론트 컨트롤러는 JSP를 실행하기 전에
//    세션에 저장된 name, age 값을 ServletRequest에 복사해주는 일을 하지 않는다.
// => 또한 메서드를 호출할 때 
//    @ModelAttribute에 지정된 값을 넘겨주지 않는다.
public class Test09 {

    
    @RequestMapping(value="/m1")
    public String m1(HttpSession session, Model model) {

        
        // 보관소에 저장된 값을 확인해보자.
        return "v03/test09/m1";
    }

    @RequestMapping(value="/m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @ModelAttribute("name") String name,
            @ModelAttribute("age") String age) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("name=%s\n", name));
        buf.append(String.format("age=%s\n", age));
        
        // 보관소에 저장된 값을 확인해보자.
        return buf.toString();
    }
    
    
}
