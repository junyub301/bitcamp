package java100.app.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import java100.app.domain.Member;
import java100.app.util.Prompts;

public class MemberController implements Controller  {

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
        case "/member/add": this.doAdd(request, response); break;
        case "/member/list": this.doList(request, response); break;
        case "/member/view": this.doView(request, response); break;
        case "/member/delete": this.doDelete(request, response); break;
        case "/member/update": this.doUpdate(request, response); break;
        default:
            System.out.println("해당 명령이 없습니다.");
        }

        System.out.println();
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 목록]");

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "select no,name,email,regdt from ex_memb");
                ResultSet rs = pstmt.executeQuery();

                ){
            while (rs.next()) {
                out.printf("%4d, %-4s, %4s, %s\n",  
                        rs.getInt("no"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("regdt")); 
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
                        "insert into ex_memb(name,email,pwd,regdt) values(?,?,password(?),now())");

                ){
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("email"));
            pstmt.setString(3, request.getParameter("password"));

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
                        "select no,name,email,regdt from ex_memb where no=?");
                ){

            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                out.printf("번호: %d\n", rs.getInt("no"));
                out.printf("이름: %s\n", rs.getString("name"));
                out.printf("이메일: %s\n", rs.getString("email"));
                out.printf("등록일: %s\n", rs.getString("regdt"));
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

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "update ex_memb set name=?,email=?,pwd=password(?) where no=?");

                ){
            pstmt.setString(1, request.getParameter("email"));
            pstmt.setString(2, request.getParameter("name"));
            pstmt.setString(3, request.getParameter("password"));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("no")));


            // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
            if (pstmt.executeUpdate() > 0 ) { 
                out.println("변경하였습니다..");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", request.getParameter("no"));
            }

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "delete from ex_memb where no=?");
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
