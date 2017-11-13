package bitcamp.java100.ch14.ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyBufferedOutputStream extends FileOutputStream {

    byte[] buf = new byte[8192];
    int len;
    int cursor;



    public MyBufferedOutputStream(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void write(int b) throws IOException {
        if (cursor == buf.length) {
            this.write(buf);
            cursor = 0;
        }

        buf[cursor++] = (byte)b ;
    }
    
    @Override
    public void flush() throws IOException {
        this.write(buf, 0, cursor);
        cursor = 0;
    }
}
