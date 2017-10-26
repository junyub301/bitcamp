package bitcamp.java100.ch07.ex5;

public class C extends A {
   
    C(String msg) {
        //super("하이");
        super(100);
        System.out.println("C() 생성자 호출 - " + msg  );
    }

}
