package bitcamp.java100.ch03;
public class Test17_10 {

    static void m1() {
        System.out.println("m1() ----> ");
        m2();
        System.out.println("m1() <----");
    }
    
    static void m2() {
        System.out.println("    m2() ----> ");
        m3();
        System.out.println("    m2() <----");
    }
    
    static void m3() {
        System.out.println("        m3() ----> ");
        m4();
        System.out.println("        m3() <----");
    }
    
    static void m4() {
        System.out.println("            m4()...");
    }
    
    public static void main(String[] args){

        System.out.println("main() ===> ");
        m1();
        System.out.println("main()<===");
    }

}