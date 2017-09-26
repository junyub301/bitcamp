package bitcamp.java100;
public class Test11_7 {
      
    public static void main(String[] args){
        
        // 자바는 정수를 2의 보수 방식으로 메모리에 저장한다.

        // 양의 정수 값을 메모리에 저장하는 방법
        // 100 = 0000 0000 0000 0000 0000 0000 0110 0100
        System.out.println(100);
        System.out.println(Integer.toBinaryString(100)); // 이진수로 바꾼다.
        
        // 음의 정수 값을 메모리에 저장하는 방법
        // -100 = 1111 1111 1111 1111 1111 1111 1001 1100
        System.out.println(-100);
        System.out.println(Integer.toBinaryString(-100));
    }
    
}

// ## 비트 개수로 표한할수 있는 최대 값?
/* n비트 의 최댓값 : (2^n -1)/2 
   11 = 100 -1
   1*(2^1)+1*(2^0) = 2^2-1
    음수까지 고려한다면 2로 나눈다. 
*/