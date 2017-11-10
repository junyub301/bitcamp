package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_5 {


    public static void main(String[] args) throws Exception {

        
        File file = new File(".");

        // ver 5 : list()에서 사용할 필터 클래스를 익명 클래스로 만든다.
        // => 단 저 위에 멀리 익명 클래스의 크도를 두지 말고 그 익명 클래스를 사용하는 코드 가까이에 두어라.
        String[] filenames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.startsWith("."))
                    return true;
                else
                    return false;
            }
        });

        for(String name : filenames) {
            System.out.println(name);
        }
    }
}
 