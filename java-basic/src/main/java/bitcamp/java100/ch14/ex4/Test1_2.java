package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_2 {

    public static void main(String[] args) throws Exception {
        // music 추가전
//        Score3 s = new Score3("홍길동", 800, 900, 1000);

        Score3 s = new Score3("홍길동", 800, 900, 1000, 900);
        
        
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test2_new.dat"));
        
        // 조건
        // serialization을 허락해야만 직렬화를 수행할 수 있다.
        // 허락 방법?
        // 클래스 선언부에 java.io.Serializable 규칙(인터페이스)을 구현한다

        
        out.writeObject(s);
        
        out.close();
        
        System.out.println("출력을 완료");
    }
}
