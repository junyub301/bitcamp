package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.domain.Room;
import java100.app.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
    
    @Autowired RoomService roomService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="lc", required=false) String[] locations,
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
        options.put("words",locations);
        options.put("orderColumn",orderColumn);
        options.put("align",align);
        

        int totalCount = roomService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        // view 컴포넌트가 사용할 값을 model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", roomService.list(pageNo, pageSize, options));

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "room/list";
    }
    
    @RequestMapping("add")
    public String add(Room room) throws Exception {
        
        roomService.add(room);
        return "redirect:list"; 
        }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        

        roomService.delete(no);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "room/form";
    }
}
