package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;

public class RoomController implements Controller {
    
    RoomDao roomDao = new RoomDao();

    private static final long serialVersionUID = 1L;

    Scanner keyScan = new Scanner(System.in);

    @Override
    public void destroy() {}

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }


    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/room/add": this.doAdd(request, response); break;
        case "/room/list": this.doList(request, response); break;
        case "/room/delete": this.doDelete(request, response); break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }   
    }


    private void doList(Request request, Response response) {

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

    private void doAdd(Request request, Response response) {

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

    private void doDelete(Request request, Response response) {
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
