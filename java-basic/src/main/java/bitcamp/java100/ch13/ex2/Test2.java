package bitcamp.java100.ch13.ex2;

public class Test2 {
    
    public static void main(String[] args) {
        try {
        System.out.printf("%d / %d = %d\n", 20, 0, 20 / 0);
    } catch (RuntimeException e) {
        System.out.println("나누기 실행중 오류 발생!");
    }
    }
}
