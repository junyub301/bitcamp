package bitcamp.java100.ch13.ex8;

public class Test3 {

    static void m1() {
        m2();
    }
    
    static void m2() {
        m3();
    }
    
    static void m3() {
        m4();
    }
    
    static void m4() {
        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
        }
    }

}
