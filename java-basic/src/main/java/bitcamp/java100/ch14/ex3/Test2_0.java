package bitcamp.java100.ch14.ex3;

import java.io.FileInputStream;

public class Test2_0 {

    public static void main(String[] args) throws Exception {
        
        Score s = new Score();
        
        FileInputStream in = new FileInputStream("test1.dat");

        int len = in.read();
        
        byte[] bytes = new byte[len];
        
        in.read(bytes);
        
        s.setName(new String(bytes, "UTF-8"));
        
        s.setKor(in.read());
        s.setEng(in.read());
        s.setMath(in.read());
        
        in.close();
        System.out.println(s);
    }
}
