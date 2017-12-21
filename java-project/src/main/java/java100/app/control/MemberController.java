package java100.app.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Controller
public class MemberController {

    @Autowired MemberDao memberDao;
    
    
    @RequestMapping("/member/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Member> list = memberDao.selectList();
        request.setAttribute("list", list);
        
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/member/list.jsp";
        
        
    }
    
    @RequestMapping("/member/add")
    public String add(
            Member member,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        memberDao.insert(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }
    
    @RequestMapping("/member/delete")
    public String delete(@RequestParam("no") int no,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        memberDao.delete(no);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }
    
    @RequestMapping("/member/form")
    public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/member/form.jsp";
    }
    
    @RequestMapping("/member/update")
    public String update(
            Member member,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        memberDao.update(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }
    
    @RequestMapping("/member/view")
    public String view(@RequestParam("no") int no,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Member member = memberDao.selectOne(no); 
        
        request.setAttribute("member", member);
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/member/view.jsp";
    }

}
