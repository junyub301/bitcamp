package java100.app.servlet.room;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/room/add")
@SuppressWarnings("serial")
public class RoomAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
        
        Room room = new Room();
        room.setName(request.getParameter("name"));
        room.setLocation(request.getParameter("loc"));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        
        int count = roomDao.insert(room);
        
        request.setAttribute("count", count); 
        
        response.setContentType("text/html; charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/room/add.jsp");
        rd.include(request, response);
    }
}
