package bitcamp.java100.ch14.ex2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_4 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("sample/jls9.pdf")));
        
        // 바이트 단위로 데이터를 출력하는 객체
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("sample/jls9-4s.pdf")));
        
        int b;
        long start = System.currentTimeMillis();
        
        while((b = in.read()) != -1) {
            out.write(b);
        }
        
        out.flush();
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end -start);

        
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }

}
