package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_0 {

    public static void main(String[] args) throws Exception {
        
        Score s = new Score("홍길동", 800, 900, 1000);
        
        
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test0.dat"));
        
        // 조건
        // serialization을 허락해야만 직렬화를 수행할 수 있다.
        
        out.writeObject(s);
        
        out.close();
        
        System.out.println("출력을 완료");
    }
}
