package bitcamp.java100.ch08.ex8;

public class Test2 {
    static void m1(byte a, byte b) {
        System.out.println("m1(byte, byte)");
    }
    
    static void m1(short a, short b) {
        System.out.println("m2(short, short)");
    }
    static void m1(int a, int b) {
        System.out.println("m3(int, int)");
    }
    public static void main(String[] args) {

        m1(10, 20);
        m1((short)10, (short)20);
        m1((byte)10, (byte)20);
        
    }

}
