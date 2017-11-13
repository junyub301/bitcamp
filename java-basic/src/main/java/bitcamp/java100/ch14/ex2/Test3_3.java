package bitcamp.java100.ch14.ex2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_3 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        FileInputStream in = new FileInputStream(new File("sample/jls9.pdf"));
        BufferedInputStream in2 = new BufferedInputStream(in);
        
        // 바이트 단위로 데이터를 출력하는 객체
        FileOutputStream out = new FileOutputStream(new File("sample/jls9-4s.pdf"));
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        
        int b;
        long start = System.currentTimeMillis();
        
        while((b = in2.read()) != -1) {
            out2.write(b);
        }
        
        out2.flush();
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end -start);
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }

}
