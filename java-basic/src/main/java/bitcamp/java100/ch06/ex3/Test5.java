package bitcamp.java100.ch06.ex3;

public class Test5 {

    static int v1 = 100;
    static void m1() {
        System.out.println("m1()");
    }
    
    int v2 = 200;
    void m2() {
        System.out.println("m2()");
    }
    
    public static void main(String[] args) {

        System.out.println(v1);
        m1();
        
        // System.out.println(v2); -> 컴파일 오류
        // m2(); -> 컴파일 오류
        
        Test5 obj1 = new Test5();
        obj1.v2 = 300;
        obj1.m2();
    }

}
