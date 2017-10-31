package bitcamp.java100.ch10.ex1;

import bitcamp.java100.ch10.ex1.other.C;

public class Test1 {
    
    public static void main(String[] args) {
        A obj = new A();
        bitcamp.java100.ch10.ex1.other.B obj2 = new bitcamp.java100.ch10.ex1.other.B();
        C obj4 = new C();
//        D obj5 = new D(); -> 컴파일 오류 : D클래스는 같은 패키지 안에서만 사용하도록 만들었다.
        
        F obj6 = new F();
        G obj7 = new G();
    }

}
