package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import java100.app.domain.Board;

public class BoardController extends GenericController<Board>  {
    
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
                case "/board/add": this.doAdd(request, response); break;
                case "/board/list": this.doList(request, response); break;
                case "/board/view": this.doView(request, response); break;
                case "/board/delete": this.doDelete(request, response); break;
                case "/board/update": this.doUpdate(request, response); break;
                default:
                    response.getWriter().println("해당 명령이 없습니다.");
                }
                System.out.println();
    }

    private void doList(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[게시물 목록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "select no,title,regdt,vwcnt from ex_board");
                ResultSet rs = pstmt.executeQuery();

                ){
            while (rs.next()) {
                out.printf("%4d, %-4s, %4s, %s\n",  
                        rs.getInt("no"),
                        rs.getString("title"),
                        rs.getDate("regdt"),
                        rs.getInt("vwcnt")); 
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
                        "insert into ex_board(title,conts,regdt) values(?,?,now())");

                ){
            pstmt.setString(1, request.getParameter("title"));
            pstmt.setString(2, request.getParameter("contents"));

            pstmt.executeUpdate();
            out.println("저장하였습니다.");


        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        out.println("[회원 정보]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                
                PreparedStatement pstmt = con.prepareStatement(
                        "select no,title,conts,regdt,vwcnt from ex_board where no=?");
                ){

            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                out.printf("번호: %d\n", rs.getInt("no"));
                out.printf("이름: %s\n", rs.getString("title"));
                out.printf("이메일: %s\n", rs.getString("conts"));
                out.printf("등록일: %s\n", rs.getString("regdt"));
                out.printf("조회수: %s\n", rs.getInt("vwcnt"));
            } else {
                out.printf("'%s'번의 성적 정보가 없습니다.\n", request.getParameter("no"));
            }
            rs.close();
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }


    private void doUpdate(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        
        out.println("[게시물 변경]");
        
        int no = Integer.parseInt(request.getParameter("no"));

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        } 

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        
        out.println("변경했습니다.");

    }    


    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        out.println("[성적 삭제]");
        int no =Integer.parseInt(request.getParameter("no"));

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }
        
            list.remove(board);
            out.println("삭제했습니다.");

    }

    private Board findByNo(int no) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if(board.getNo() == no) {
                return board;
            }
        }//while
        return null;

    }

}
