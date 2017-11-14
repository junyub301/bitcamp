package bitcamp.java100.ch14.ex2;

import java.io.FileInputStream;

public class Test1_1 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        FileInputStream in = new FileInputStream("sample/a.jpg");
        
        // 바이트 단위로 데이터를 읽더라도 변수의 타입은 int여야 한다.
        // read() 메서드의 리턴 타입이 int이기 때문이다.
        // 실제 읽은 것은 1바이트이고 나머지 3바이트는 버린다.
        int b;
        int count = 0;
        while((b = in.read()) != -1) {
            count++;
        }
        System.out.println(count);
        
        in.close();
    }

}
