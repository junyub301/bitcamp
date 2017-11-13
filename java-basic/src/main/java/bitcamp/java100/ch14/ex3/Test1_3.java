package bitcamp.java100.ch14.ex3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test1_3 {

    public static void main(String[] args) throws Exception {
        
        Score s = new Score("홍길동", 800, 900, 1000);
        
        
        
        DataOutputStream out = new DataOutputStream(new FileOutputStream("test3.dat"));

        out.writeUTF(s.getName());
        out.writeInt(s.getKor());
        out.writeInt(s.getEng());
        out.writeInt(s.getMath());
        
        out.close();
        
        System.out.println("출력을 완료");
    }
}
