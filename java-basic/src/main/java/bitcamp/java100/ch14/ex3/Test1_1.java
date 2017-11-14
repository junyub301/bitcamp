package bitcamp.java100.ch14.ex3;

import java.io.FileOutputStream;

public class Test1_1 {

    public static void main(String[] args) throws Exception {
        
        Score s = new Score("홍길동", 800, 900, 1000);
        
        FileOutputStream out = new FileOutputStream("test1.dat");
        
        byte[] bytes =s.getName().getBytes("UTF-8"); 
        
        out.write(bytes.length);
        
        out.write(bytes);
        
        out.write(s.getKor() >> 24); // 0x -- -- -- 00 | 00 03 20
        out.write(s.getKor() >> 16); // 0x -- -- 00 00 | 03 20
        out.write(s.getKor() >> 8 ); // 0x -- 00 00 03 | 20
        out.write(s.getKor());       // 0x 00 00 03 20
        
        out.write(s.getEng() >> 24); // 0x -- -- -- 00 | 00 03 84
        out.write(s.getEng() >> 16); // 0x -- -- 00 00 | 03 84
        out.write(s.getEng() >> 8 ); // 0x -- 00 00 03 | 84
        out.write(s.getEng());       // 0x 00 00 03 84
        
        out.write(s.getMath() >> 24); // 0x -- -- -- 00 | 00 03 E8
        out.write(s.getMath() >> 16); // 0x -- -- 00 00 | 03 E8
        out.write(s.getMath() >> 8 ); // 0x -- 00 00 03 | E8
        out.write(s.getMath());       // 0x 00 00 03 E8
        
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
    }
}
