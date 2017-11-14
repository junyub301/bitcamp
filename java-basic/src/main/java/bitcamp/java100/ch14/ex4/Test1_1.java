package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {

    public static void main(String[] args) throws Exception {
        
        Score2 s = new Score2("홍길동", 800, 900, 1000);
        
        
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test1.dat"));
        
        // 조건
        // serialization을 허락해야만 직렬화를 수행할 수 있다.
        // 허락 방법?
        // 클래스 선언부에 java.io.Serializable 규칙(인터페이스)을 구현한다

        
        out.writeObject(s);
        
        out.close();
        
        System.out.println("출력을 완료");
    }
}
