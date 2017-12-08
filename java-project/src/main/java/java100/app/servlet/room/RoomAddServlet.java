package java100.app.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/room/add") 
public class RoomAddServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
        response.setContentType("text/palin;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        try {
            Room room = new Room();
            room.setName(request.getParameter("name"));
            room.setLocation(request.getParameter("loc"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            
            roomDao.insert(room);
            out.println("저장하였습니다.");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    }

}
