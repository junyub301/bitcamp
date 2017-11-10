package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Date;

public class Test5_3 {
    
    
    public static void main(String[] args) throws Exception {

        class MyFilenameFilter implements FilenameFilter {
            @Override
            public boolean accept(File dir, String name) {
                
                if (name.startsWith("."))
                    return false;
                else
                    return true;
            }
        }
        File file = new File(".");
        
        // ver 3 : list()에서 사용할 필터 클래스를 로컬 클래스로 만든다.
        // => 오직 이 클래스의 main()에서만 사용하는 클래스로 선언한다.
        String[] filenames = file.list(new MyFilenameFilter());
        
        for(String name : filenames) {
            System.out.println(name);
        }
    }
}
 