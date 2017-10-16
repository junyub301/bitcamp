package bitcamp.java100;

public class Test15_10 {
      
    public static void main(String[] args){
        
        int v1 = 0b0101_1100;
        int v2 = 0b0110_0110;
        
        // & (논리곱 AND)
        int result = v1 & v2;
        System.out.println(java.lang.Integer.toBinaryString(result)); // 이진수로 보여준다.
        
        // | (논리 합 OR)
        result = v1 | v2;
        System.out.println(java.lang.Integer.toBinaryString(result));

        // ^ (배타적 논리곱 Exclusive OR(XOR) -> 두개 값이 다를때 결과 1
        result = v1 ^ v2;
        System.out.println(java.lang.Integer.toBinaryString(result));
        
        // ~ (부정 NOT)
        result = ~v1;
        System.out.println(java.lang.Integer.toBinaryString(result));
        
        
    }

}

/* 
 * 식(Expression) => 결과를 리턴하는 명령어.
 * 문장(Statement) => 결과를 반드시 리턴하지는 않는다. 세미콜론으로 끝나야 한다.
 * 블록(Block) => 한개 이상의 문장이나 하위 블로들로 구성된 것.
 * 메서드(Method) => 다시 사용할 수 있는 블록.
 * 클래스(Class) = > 여러 개의 변수 선언과 메서들로 구성된 블록.
 */ 
