package bitcamp.java100.ch14.ex4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test2_1 {

    public static void main(String[] args) throws Exception {
        
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test1.dat"));
        
        // 조건
        // serialization을 허락해야만 직렬화를 수행할 수 있다.
        // 허락 방법?
        // 클래스 선언부에 java.io.Serializable 규칙(인터페이스)을 구현한다

        
        Score2 s = (Score2)in.readObject();
        
        in.close();
        
        System.out.println(s);
    }
}
