package bitcamp.java100.ch08.ex8;

public class Test4 {
    public static void main(String[] args) {

        A obj = new A();
        
        // 리턴 타입이 없는 메서드 호출
        obj.m1(100);
        // 값을 리턴하지 않는 메서드에서 값을 받을 수 없다.
//        int value = obj.m1(200); -> 컴파일 오류
        
        // 리턴 타입이 있는 메서드 호출
        // 주는 값을 안받아도 된다.
        obj.m2();
        // 주는값을 변수에 받을 수 있다.
        int result = obj.m2();
        System.out.println(result);
        
        
    }

}
