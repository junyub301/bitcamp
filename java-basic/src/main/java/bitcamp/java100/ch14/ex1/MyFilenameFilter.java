package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub

        //디렉토리 안에 포함된 파일 중에서 디렉토리만 리턴 배열에 포함시키자.

        File file = new File(dir, name);

        if (file.isDirectory())
            return true;
        else
            return false;
    }

}
