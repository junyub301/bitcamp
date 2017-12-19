package java100.app.control.room;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.RoomDao;
import java100.app.domain.Room;

@Component("/room/list")
public class RoomListServlet implements PageController {

    @Autowired RoomDao roomDao;
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Room> list = roomDao.selectList();

        request.setAttribute("list", list); 

        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/room/list.jsp";
    }
}
