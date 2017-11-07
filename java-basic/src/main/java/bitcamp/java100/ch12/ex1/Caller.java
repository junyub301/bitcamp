package bitcamp.java100.ch12.ex1;

public class Caller {

    public static void main(String[] args) {
        
        Protocol obj = new Callee();
        
//        Protocol이라는 인터페이스 규칙에 따라 클래스를 만들지 않았기 때문에 레퍼런스에 저장 못함.
//        다형적 변수의 법칙 적용
//        Protocol boj2 = new String(); -> 컴파일 오류
        
        obj.m1();
        obj.m2();
    }
}
