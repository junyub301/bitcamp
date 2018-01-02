package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
    
    
    @Autowired BoardDao boardDao;
    @RequestMapping("list")
    public String list(
            @RequestParam(value="nm", required=false) String[] title,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        HashMap<String,Object> params = new HashMap<>();
        params.put("names",title);
        params.put("orderColumn",orderColumn);
        params.put("align",align);
        
        model.addAttribute("list", boardDao.findAll(params));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/list";
    }

    @RequestMapping("add")
    public String add(Board board) throws Exception  {
        
        boardDao.insert(board);
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception  {
        
        
        boardDao.delete(no);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception  {
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/form";
    }


    @RequestMapping("update")
    public String update(Board board) throws Exception  {
        
        
        boardDao.update(board);

        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        boardDao.upView(no);
        
        model.addAttribute("board", boardDao.findByNo(no));
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "board/view";
    }

    
}
