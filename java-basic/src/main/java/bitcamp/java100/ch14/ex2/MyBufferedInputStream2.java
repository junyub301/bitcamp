package bitcamp.java100.ch14.ex2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream2 {
    
    // 왜 InputStream 레퍼런스를 선언했는가?
    // => InputStream 레퍼런스는 FileInpuStream 외에도 그 하위 클래스의 모든 객체를 가릴킬 수 있기 때문에
    // => 즉, 더 많은 종류의 객체를 포함하기 위해 이 타입으로 선언했다.
    InputStream worker;

    byte[] buf = new byte[8192];
    int len; // 버퍼에 저장한 바이트 개수
    int cursor; // 버퍼에서 읽을 바이트 위치
    
    public MyBufferedInputStream2(InputStream worker) throws FileNotFoundException {
        this.worker = worker;
    }

    public int read() throws IOException {
        if (cursor >= len) {
            cursor = 0;
            len = worker.read(buf);
            if (len == -1)
                return -1;
        }
        
        return buf[cursor++] & 0x000000FF;
        
    }
    

}
