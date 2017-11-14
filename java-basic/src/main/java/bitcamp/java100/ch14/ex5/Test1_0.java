package bitcamp.java100.ch14.ex5;

import java.io.FileInputStream;

public class Test1_0 {

    public static void main(String[] args) throws Exception {
        
        FileInputStream in = new FileInputStream("test.txt");
        
        int b;
        while((b = in.read()) != -1) {
            System.out.println(Integer.toHexString(b));
        }
        
        in.close();
    }

}
