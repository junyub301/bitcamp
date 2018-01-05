package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.domain.Score;
import java100.app.service.ScoreService;


@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="nm", required=false) String[] names,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        // UI 제어와 관련된 코드는 이렇게 페이지 컨트롤러에 두어야 한다.
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        HashMap<String,Object> options = new HashMap<>();
        options.put("words",names);
        options.put("orderColumn",orderColumn);
        options.put("align",align);
        
        int totalCount = scoreService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        // view 컴포넌트가 사용할 값을 model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", scoreService.list(pageNo, pageSize, options));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "score/list";
        
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreService.get(no));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "score/view";
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }
    
    @RequestMapping("add")
    public String add(Score score) throws Exception {
        
        
        scoreService.add(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreService.update(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list"; 
    }

    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        scoreService.delete(no);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    

    
}
