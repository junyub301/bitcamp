package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_4 {


    public static void main(String[] args) throws Exception {

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.startsWith("."))
                    return true;
                else
                    return false;
            }
        };
        
        File file = new File(".");

        // ver 4 : list()에서 사용할 필터 클래스를 익명 클래스로 만든다.
        // => 오직 이 클래스의 main()에서만 사용하는 클래스로 선언한다.
        String[] filenames = file.list(filter);

        for(String name : filenames) {
            System.out.println(name);
        }
    }
}
 