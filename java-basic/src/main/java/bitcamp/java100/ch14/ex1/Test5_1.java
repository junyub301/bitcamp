package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.sql.Date;

public class Test5_1 {

    public static void main(String[] args) throws Exception {

        File file = new File(".");
        
        // ver 1 : list()에서 사용할 필터 클래스는 패키지 멤버로 만든다.
        // => 오직 이 클래스에서만 사용하는 클래스인데 굳이 패키지 멤버로 만들 필요가 있을까?
        String[] filenames = file.list(new MyFilenameFilter());
        
        for(String name : filenames) {
            System.out.println(name);
        }
    }
}
