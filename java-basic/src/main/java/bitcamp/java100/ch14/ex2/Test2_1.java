package bitcamp.java100.ch14.ex2;

import java.io.FileOutputStream;

public class Test2_1 {

    public static void main(String[] args) throws Exception {

        FileOutputStream out = new FileOutputStream("./test.dat");
        
        int[] data = {0x66554420,0x66554421,0x66554422,0x66554423,0x66554424,
                0x66554425,0x66554426,0x66554427,0x66554428,0x66554429};

        for (int b : data) {
            System.out.println(Integer.toHexString(b));
            // 파라미터 타입은 int이다, 출력할 때는 맨끝 1바이트만 출력한다. 그래서 항상 바이트 단위로 출력한다.
            out.write(b);
        }
        
        out.close();
    }

}
