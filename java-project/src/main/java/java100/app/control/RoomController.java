package java100.app.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;

@Controller
public class RoomController {

    @Autowired RoomDao roomDao;
    
    @RequestMapping("/room/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Room> list = roomDao.selectList();

        request.setAttribute("list", list); 

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/room/list.jsp";
    }
    
    @RequestMapping("/room/add")
    public String add(
            Room room,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        roomDao.insert(room);
        return "redirect:list.do"; 
        }
    
    @RequestMapping("/room/delete")
    public String delete(@RequestParam("no") int no,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        

        roomDao.delete(no);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }
    
    @RequestMapping("/room/form")
    public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/room/form.jsp";
    }
}
