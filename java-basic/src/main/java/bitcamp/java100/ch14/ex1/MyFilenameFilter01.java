package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter01 implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        
        //모든 파일이나 디렉토리에 대해 리턴 배열에 포함 시킨다.
        
        return true;
    }
    
    
    

}
