package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member/view")
public class MemberViewController implements PageController {

    @Autowired MemberDao memberDao;
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Member member = memberDao.selectOne(no); 
        
        request.setAttribute("member", member);
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/member/view.jsp";
    }

}