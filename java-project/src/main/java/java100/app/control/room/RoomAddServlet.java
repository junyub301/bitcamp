package java100.app.control.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.RoomDao;
import java100.app.domain.Room;

@Component("/room/add")
public class RoomAddServlet implements PageController {
    
    @Autowired RoomDao roomDao;
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Room room = new Room();
        room.setName(request.getParameter("name"));
        room.setLocation(request.getParameter("loc"));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        
        roomDao.insert(room);
     // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }
}
