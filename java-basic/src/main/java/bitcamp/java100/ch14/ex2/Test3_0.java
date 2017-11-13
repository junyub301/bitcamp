package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_0 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        FileInputStream in = new FileInputStream(new File("sample/d.jpg"));
        
        // 바이트 단위로 데이터를 출력하는 객체
        FileOutputStream out = new FileOutputStream(new File("sample/d2.jpg"));
        
        int b;
        while((b = in.read()) != -1) {
            out.write(b);
        }
        
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }

}
