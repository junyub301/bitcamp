package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RoomController implements Controller {

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
     

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                    PreparedStatement pstmt = con.prepareStatement(
                            "select no,loc,name,capacity from ex_room");
                    ResultSet rs = pstmt.executeQuery();

                    ){
                while (rs.next()) {
                    out.printf("%4d, %4s, %4s, %4s\n",  
                            rs.getInt("no"),
                            rs.getString("loc"),
                            rs.getString("name"),
                            rs.getString("capacity")
                            ); 
                }
            } catch (Exception e ) {
                e.printStackTrace();
                out.println(e.getMessage());
            }
    }

    private void doAdd(Request request, Response response) {

        PrintWriter out = response.getWriter();
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "insert into ex_room(name,loc,capacity) values(?,?,?)");
                ){
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("loc"));
            pstmt.setString(3, request.getParameter("capacity"));

            pstmt.executeUpdate();
            out.println("저장하였습니다.");

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "delete from ex_room where no=?");
                ){
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

            if (pstmt.executeUpdate() > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", request.getParameter("no"));
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    



}
