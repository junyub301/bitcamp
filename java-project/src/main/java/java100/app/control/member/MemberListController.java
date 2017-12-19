package java100.app.control.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member/list")
public class MemberListController implements PageController {

    @Autowired MemberDao memberDao;
    
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Member> list = memberDao.selectList();
        request.setAttribute("list", list);
        
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/member/list.jsp";
        
        
    }
}
