package bitcamp.java100.ch14.ex2;

import java.io.IOException;
import java.io.OutputStream;

public class MyBufferedOutputStream2 {

    OutputStream worker;
    
    byte[] buf = new byte[8192];
    int len;
    int cursor;



    public MyBufferedOutputStream2(OutputStream worker) {
        this.worker = worker;
    }

    public void write(int b) throws IOException {
        if (cursor == buf.length) {
            worker.write(buf);
            cursor = 0;
        }

        buf[cursor++] = (byte)b ;
    }
    
    public void flush() throws IOException {
        worker.write(buf, 0, cursor);
        cursor = 0;
    }
}
