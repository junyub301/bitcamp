package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberDao memberDao;
    
    
    @RequestMapping("list")
    public String list(@RequestParam(value="word", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        HashMap<String,Object> params = new HashMap<>();
        params.put("words",words);
        params.put("orderColumn",orderColumn);
        params.put("align",align);
        

        model.addAttribute("list", memberDao.findAll(params));
        
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "member/list";
        
        
    }
    
    @RequestMapping("add")
    public String add(Member member) throws Exception {

        memberDao.insert(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        
        memberDao.delete(no);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "member/form";
    }
    
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        
        memberDao.update(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        
        model.addAttribute("member", memberDao.findByNo(no));
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "member/view";
    }

}
