package java100.app.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
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
@WebServlet("/room/list") 
public class RoomListServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
        response.setContentType("text/palin;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");

            try {
                List<Room> list = roomDao.selectList();
                for (Room room : list) {
                    out.printf("%4d, %4s, %4s, %4s\n",  
                            room.getNo(),
                            room.getLocation(),
                            room.getName(),
                            room.getCapacity()
                            ); 
                }
            } catch (Exception e ) {
                e.printStackTrace();
                out.println(e.getMessage());
            }
    }

}
