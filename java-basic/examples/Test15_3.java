package bitcamp.java100;

public class Test15_3 {
      
    public static void main(String[] args){
        
        byte b1 = 20, b2 = 22;
        short s1 = 30, s2 = 33;
        int i1 = 40, i2 = 44;
        long l1 = 50, l2 = 55;
        float f1 = 3.14f, f2 = 45.32f;
        double d1 = 4567.8988, d2 = 9876.5432;
        
        // byte 와 short
        int r1 = b1 + s1;
        r1 = b1 +i1;
        r1 = i1 + s1;

        // int, byte, short vs long
        // r1 = i1 + l1; -> 계산 결과는 long 타입이다. 컴파일 오류
        // r1 = b1 + l1; -> 계산 결과는 long 타입이다. 컴파일 오류
        // r1 = s1 + l1; -> 계산 결과는 long 타입이다. 컴파일 오류
        long r2 = i1 + l1;
        r2 = b1 + l1;
        r2 = s1 + l1;
        
        // byte, int, short, long vs float
        // long r3 = b1 + f1; -> 계산결과는 float 타입이다. 컴파일 오류 
        // r3 = s1 + f1; -> 계산결과는 float 타입이다. 컴파일 오류
        // r3 = il +f1; -> 계산결과는 float 타입이다. 컴파일 오류
        // r3 = l1 +f1; -> 계산결과는 float 타입이다. 컴파일 오류
        
        float r4 = b1 + f1;
        r4 = s1 + f1;
        r4 = i1 +f1;
        r4 = l1 + f1;
        
        // byte, short, int, long, float vs double
        // float r5 = f1 + d1; -> 계산 결과는 double타입이다. 컴파일 오류
        
        double r6 = f1 + d1;
        r6 = b1 + d1;
        r6 = s1 + d1;
        r6 = i1 + d1;
        r6 = l1 + d1;
        
        // 암시적 형변환 : 서로 다른 타입의 값을 계산하려할 경우 자동으로                          타입을 맞춰주는것
        // 암시적 형변환 : 서로 다른 타입의 값을 계산하려할 경우 자동으로                          타입을 맞춰주는것
        
        
    }
    
}