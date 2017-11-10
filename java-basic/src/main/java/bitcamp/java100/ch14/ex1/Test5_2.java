package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Date;

public class Test5_2 {
    
    static class MyFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {

            File file = new File(dir, name);

            if (file.isDirectory())
                return false;
            else
                return true;
        }
    }
     
    public static void main(String[] args) throws Exception {

        File file = new File(".");
        
        // ver 2 : list()에서 사용할 필터 클래스를 중첩 클래스로 만든다.
        // => 오직 이 클래스에서만 사용하는 클래스로 선언한다.
        String[] filenames = file.list(new MyFilenameFilter());
        
        for(String name : filenames) {
            System.out.println(name);
        }
    }
}
