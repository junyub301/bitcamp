package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Member;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        
        HashMap<String,Object> options = new HashMap<>();
        options.put("words",words);
        options.put("orderColumn",orderColumn);
        options.put("align",align);
        

        int totalCount = memberService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", memberService.list(pageNo, pageSize, options));
        
        return result;
        
        
    }
    
    @RequestMapping("add")
    public String add(Member member) throws Exception {

        memberService.add(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        
        memberService.delete(no);
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
        
        memberService.update(member);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        
        model.addAttribute("member", memberService.get(no));
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "member/view";
    }

}
