package bitcamp.java100;

public class Test15_2 {
      
    public static void main(String[] args){
        

        // byte와 short변수로 연산을 하면 int형 임시메모리가 만들어지기 때문에     연산결과는 int가 된다.
        
        byte b1 = 10;
        byte b2 = 20;
        // byte b3 = b1 - b2; -> 컴파일 오류

        short s1 = 10;
        short s2 = 20;
        // short s3 = s1 + s2; -> 컴파일 오류

        int r = s1 + s2;
        long r2 = s1 + s2;


    }

}