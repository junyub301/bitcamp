package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelect {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        System.out.println("연결되었음!");
        
        // SQL문을 보내는 일을 할 객체를 Connection 객체로 부터 얻는다.
        // 빈 SQL문 객체를 만든다.
        Statement stmt = con.createStatement();

        // Statement 객체의 메서드를 통해 SQL문을 서버에 보낸다.
        // select를 실행 할 때는 executeQuery() 메서드를 사용해야한다.
        ResultSet rs = stmt.executeQuery("select * from jdbc_test");

        // ResultSet 도구를 사용하여 서버에 준비된 결과를 한개씩 가져오기
        // next() 서버에서 데이터를 한 개(레코드) 가져왔으면 true, 가져올 레코드가 없으면 false 리턴
        while (rs.next()) {
            System.out.printf("%d, %s, %s, %s, %d\n", 
                    rs.getInt("no"), 
                    rs.getString(2), 
                    rs.getString("conts"), 
                    rs.getString("regdt")/*.toString() */, 
                    rs.getInt("vwcnt") );
        }
        rs.close();
        stmt.close();
        con.close();


    }
}
