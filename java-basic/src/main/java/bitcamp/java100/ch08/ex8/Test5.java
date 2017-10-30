package bitcamp.java100.ch08.ex8;

public class Test5 {
    
    static int plus(int a, int b) {
        return a + b;
    }
    
//    static int plus(int v1, int v2) {
//        return v1 + v2 + v2;
//    }
    static void m1(int a, String b) {
        System.out.println("m1(int, String)");
        
    }

    static void m1(String a, int b) {
        System.out.println("m1(String, int)");
        
    }
    public static void main(String[] args) {
        
        System.out.println(plus(10,20));
        m1(10, "aaa");
        m1("aaa", 10);
        }

}
