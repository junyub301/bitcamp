package bitcamp.java100.ch02;
public class Test12_6 {
      
    public static void main(String[] args){

     byte b1 = 50;
     byte b2 = 50;
     byte b3 ;

     // 직접 값을 입력한것 : 리터럴(Literal)
     b3 = 100;

     // 리터럴이 아닐경우 메모리에 저장할 수 없다.
     // 또한 자바의 최소 연산 단위는 4바이트 int이다 
     // -> byte나 short 메모리의 값을 연산 할 때 먼저 4바이트 int형 임시              메모리를 만든 다음 그 값을 정장한 후 연산을 수정한다. 따라서 그 연산       결과는 반든시 4바이트 크기를 갖는다.
     //b3 = b1 + b2; -> 컴파일 오류

     // 리터럴과 변수 연산도 4바이트로 간주 -> byte,short 메모리에 저장 안됨
     // but 리터럴과 리터럴 연산은 리터럴로 간주.
     b3  = 50+50;
     // b3 = b1 + 50; -> 컴파일 오류

     short s1;
     // s1 = b1+b2; -> 연산결과는 int이기 때문에 short에 저장할 수 없다.
     
    }

}