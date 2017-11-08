package bitcamp.java100.ch13.ex8;

public class Test2 {

    static void m1() throws Exception {
        m2();
    }
    
    static void m2() throws Exception {
        m3();
    }
    
    static void m3() throws Exception {
        m4();
    }
    
    static void m4() throws Exception {
        throw new Exception();
    }
    
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
        }
    }

}
