package bitcamp.java100;
public class Test11_5 {
      
    public static void main(String[] args){

        // 10진수의 자릿수 표현 : 밑줄(_)을 이용하여 자릿수를 표현할 수 있다.
        // 위치는 상관없다.
        System.out.println(1456781234);
        System.out.println(14_5678_1234);
        System.out.println(1_456_781_234);

        // 8진수 정수 값 표현 : 0으로 시작한다.
        System.out.println(0144);

        // 16진수 정수 값 표현 : 0x 또는 0X로 시작한다.
        System.out.println(0x64);
        
        // 2진수 정수 값 표현 : 0b 또는 0B로 시작한다.
        // 특히 숫자가 많은 2진수에 자릴수를 적용하면 편하다.
        System.out.println(0b0110_0100);
    }
        
    }