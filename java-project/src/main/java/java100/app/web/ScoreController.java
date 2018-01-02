package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;


@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreDao scoreDao;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="nm", required=false) String[] names,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        HashMap<String,Object> params = new HashMap<>();
        params.put("words",names);
        params.put("orderColumn",orderColumn);
        params.put("align",align);
        
        model.addAttribute("list", scoreDao.findAll(params));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "score/list";
        
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreDao.findByNo(no));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "score/view";
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }
    
    @RequestMapping("add")
    public String add(Score score) throws Exception {
        
        
        scoreDao.insert(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreDao.update(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list"; 
    }

    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        scoreDao.delete(no);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    

    
}
