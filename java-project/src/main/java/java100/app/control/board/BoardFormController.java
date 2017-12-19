package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.control.PageController;

@Component("/board/form")
public class BoardFormController implements PageController {
    
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/board/form.jsp";
    }

}
