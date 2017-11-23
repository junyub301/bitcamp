package bitcamp.java100.ch17.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test3 {

    public static void main(String[] args) throws Exception {


        java.sql.Driver driver = new com.mysql.jdbc.Driver();

        // java.sql.Driver 구현체를 JDBC Driver 관리자에 등록
        DriverManager.registerDriver(driver);
        
        // DBMS에 연결하기 1
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");

        //DBMS에 연결하기 2
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        System.out.println("연결되었음!");

        con.close();


    }
}
