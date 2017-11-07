package bitcamp.java100.ch12.ex1;

public class Callee implements Protocol {

    @Override
    public void m1() {
        System.out.println("m1()...");
    }

    @Override
    public void m2() {
        System.out.println("m2()...");
        
    }

    
}
