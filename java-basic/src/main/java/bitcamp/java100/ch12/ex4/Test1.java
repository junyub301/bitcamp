package bitcamp.java100.ch12.ex4;

public class Test1 {

    public static void main(String[] args) {

        Protocol obj;
        obj = new A();
        
        obj = new B();
        
        if (new A() instanceof Protocol) {
            System.out.println("A의 객체는 Protocol 구현체이다.");
        }
        
        if (new B() instanceof Protocol) {
            System.out.println("B의 객체는 Protocol 구현체이다.");
        }
        
    }

}
