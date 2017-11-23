package bitcamp.java100.ch17.ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);


        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","1111");

        PreparedStatement pstmt = con.prepareStatement("insert into jdbc_test(title,conts,regdt) values(?,?,now())");

        while (true) {
            System.out.print("제목? ");
            String title = keyboard.nextLine();
            
            
            System.out.print("내용? ");
            String contents = keyboard.nextLine();

            pstmt.setString(1, title);
            pstmt.setString(2, contents);

            pstmt.executeUpdate();

            System.out.println("입력 완료!");

            System.out.print("계속 입력하시겠습니까?(Y/n)");
            String str = keyboard.nextLine().toLowerCase();
            if (str.equals("n")) 
                break;

        }

        pstmt.close();
        con.close();
        keyboard.close();

    }
}
