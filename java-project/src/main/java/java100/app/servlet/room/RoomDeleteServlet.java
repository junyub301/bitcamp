package java100.app.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/room/delete") 
public class RoomDeleteServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
        response.setContentType("text/palin;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            
            int no = Integer.parseInt(request.getParameter("no"));

            if (roomDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }
}

