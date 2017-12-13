package java100.app.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>강의실관리</title>");
        out.println("<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>");
        out.println("<style>");
        out.println(".container {");
        out.println("   width: 680px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");      
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>강의실 상세 정보</h1>");

        out.println("<form method='post'>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='loc'class='col-sm-2 col-form-label'>지역</label>");
        out.println("<div class='col-sm-10'>");
        out.println("<input id='loc' type='text' name='loc' >");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='name'class='col-sm-2 col-form-label'>이름</label>");
        out.println("<div class='col-sm-10'>");
        out.println("<input id='name' type='text' name='name' >");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<label for='capacity'class='col-sm-2 col-form-label'>수용인원</label>");
        out.println("<div class='col-sm-10'>");
        out.println("<input id='capacity' type='number' name='capacity'>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-group row'>");
        out.println("<div class='col-sm-10'>");
        out.println("<button  class=\"btn btn-primary\">추가</button>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>강의실관리</title>");
        out.println("<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>");
        out.println("<style>");
        out.println(".container {");
        out.println("   width: 680px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");      
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>강의실 등록 결과</h1>");
        
        try {
            Room room = new Room();
            room.setName(request.getParameter("name"));
            room.setLocation(request.getParameter("loc"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            
            roomDao.insert(room);
            out.println("<p>저장하였습니다.</p>");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        out.println("<p><a href='list' class='btn btn-primary btn-sm'>목록</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        
    }

}
