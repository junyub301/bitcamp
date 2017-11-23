package bitcamp.java100.ch17.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test4 {

    public static void main(String[] args) throws Exception {

        // java.sql.Driver를 구현한 클래스를 단지 로딩만 한다.
        // java.lang.Class.forName() 메서드는 파라미터에 주어진 클래스를 찾아서 로딩하는 일을 한다.
        // com.mysql.jdbc.Kriver 클래스는 static 블록에는 자신의 객체를 생성해서
        // DriverManager에게 등록하는 코드가 들어있다. 
        // 그래서 클래스를 로딩하는 것만으로 Driver 객체가 자동 등록된다.
        // 즉, 개발자가 직접 Driver 객체를 생성하고 DriverManager에게 등록할 필요가 없다.
        Class.forName("com.mysql.jdbc.Driver");

        // DriverManger에게 MySQL 서버에 연결해 달라고 요청하면,
        // DriverManager는 일단 등록된 Driver에서 MySQL 연결을 수행할 수 있는 Driver 객체를 찾는다.
        // 없으면, Method Area에 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        System.out.println("연결되었음!");

        con.close();


    }
}
