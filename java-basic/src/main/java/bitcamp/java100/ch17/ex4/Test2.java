package bitcamp.java100.ch17.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        // SQL문 준비
        PreparedStatement pstmt = con.prepareStatement(
                "insert into jdbc_test(title,conts,regdt) values(?,?,now())", 
                Statement.RETURN_GENERATED_KEYS);
        
        
        // 값 준비
        pstmt.setString(1, "제목이래요");
        pstmt.setString(2, "내용이래요...");
        
        // SQL 전송
        pstmt.executeUpdate();
        System.out.println("입력 완료!");
        
        ResultSet autokeyRS = pstmt.getGeneratedKeys();
        
        autokeyRS.next();
        
        System.out.println(autokeyRS.getInt(1));
        
        autokeyRS.close();
        

        
        pstmt.close();
        con.close();


    }
}
