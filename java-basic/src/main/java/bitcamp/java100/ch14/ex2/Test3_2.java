package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_2 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        FileInputStream in = new FileInputStream(new File("sample/jls9.pdf"));
        
        // 바이트 단위로 데이터를 출력하는 객체
        FileOutputStream out = new FileOutputStream(new File("sample/jls9-3.pdf"));
        
        
        byte[] buf = new byte[8192];
        int len = 0;
        long start = System.currentTimeMillis();
        
        while((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end -start);
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }

}
