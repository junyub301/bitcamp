package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test3 {

    public static void main(String[] args) throws Exception {

        File file = new File(".");
        
        
        String[] files = file.list();
        
        for(String name : files) {
            System.out.println(name);
        }
    }
}
 