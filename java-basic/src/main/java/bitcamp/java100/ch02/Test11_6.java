package bitcamp.java100.ch02;
public class Test11_6 {
      
    public static void main(String[] args){

        // 정수값음 기본으로 4바이트 크기를 갖는다.
        // -2^31 ~ 2^31 = -2147483648 ~ 2147483647
        System.out.println(-21_4748_3648);
        System.out.println(21_4748_3647);
        
       // System.out.println(-21_4748_3649);
       // System.out.println(21_4748_3648);

       /* 해결책
        자바는 8바이트 크기의 정수값도 표현 할 수 있다.
        숫자뒤에 L또는 l을 붙인다. */
        System.out.println(-21_4748_3649L);
        System.out.println(21_4748_3648L);

        System.out.println(10); // 4바이트 정수 값
        System.out.println(10L); // 8바이트 정수 값

        // 8바이트 크기의 가장 큰 정수값과 작은 정수값
        System.out.println(-922_3372_0368_5447_5808L);
        System.out.println(-922_3372_0368_5447_5807L);
    }
    
}

// ## 비트 개수로 표한할수 있는 최대 값?
/* n비트 의 최댓값 : (2^n -1)/2 
   11 = 100 -1
   1*(2^1)+1*(2^0) = 2^2-1
    음수까지 고려한다면 2로 나눈다. 
*/