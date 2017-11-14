package bitcamp.java100.ch14.ex5;

import java.io.FileWriter;

public class Test2_1 {

    public static void main(String[] args) throws Exception {
    
        FileWriter out = new FileWriter("test3.txt");
        
        String str = "ABC가각";

        out.write(str);
        
        out.close();
        System.out.println("출력하였습니다.");
    }
    
}
