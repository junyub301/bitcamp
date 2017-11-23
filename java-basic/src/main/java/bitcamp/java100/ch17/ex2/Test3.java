package bitcamp.java100.ch17.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test3 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        System.out.println("연결되었음!");
        
        // SQL문을 보내는 일을 할 객체를 Connection 객체로 부터 얻는다.
        // 빈 SQL문 객체를 만든다.
        Statement stmt = con.createStatement();

        // Statement 객체의 메서드를 통해 SQL문을 서버에 보낸다.
        stmt.executeUpdate("delete from jdbc_test where no=1");
        
        System.out.println("삭제 완료!");
        
        stmt.close();
        con.close();


    }
}
