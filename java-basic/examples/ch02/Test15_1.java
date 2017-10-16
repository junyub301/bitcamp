package bitcamp.java100;

public class Test15_1 {
      
    public static void main(String[] args){

        System.out.printf("10 + 20 = %d\n", 10 + 20);
        System.out.printf("10 - 20 = %d\n", 10 - 20);
        System.out.printf("10 * 20 = %d\n", 10 * 20);
       
        /* 연산규칙
           - 연산은 항상 같은 타임끼리만 가능
           - 다른 타입과연산이 불가능하다.
           - 따라서 피연산자들이 int일 경우 그 결과도 int이다.
        */
        //System.out.printf("5 / 2 = %f\n", 10 / 20); -> 컴파일 오류
        System.out.printf("5 / 2 = %d\n", 5 / 2); // 나눗셈은 int

        /* 형식 문자열을 작성할 때 '%'는 명ㄹ여어로 사용된다. 만약 그냥 일반 문자로 출력하고 싶다면 %앞에 %를 붙여라. */
        System.out.printf("10 %% 20 = %d\n", 10 % 20);
    }

}