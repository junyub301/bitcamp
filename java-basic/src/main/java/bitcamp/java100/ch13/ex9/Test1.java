package bitcamp.java100.ch13.ex9;

public class Test1 {

    static void m1() throws Exception {
        throw new Exception();
    }
    
    static void m2() throws Exception {
        
        throw new Exception("이래서..저래서.. 예외가 발생했어요.");
    }
    
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            System.out.println("예외가 발생했어요!");
        }
        try {
            m2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
