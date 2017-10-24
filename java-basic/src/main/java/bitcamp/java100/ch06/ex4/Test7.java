package bitcamp.java100.ch06.ex4;

public class Test7 {

    // 개별적으로 다뤄야 하는 값은 인스턴스 메서드
    // 공통으로 다뤄야 하는 값은 클래스 메서드
    public static void main(String[] args) {

        Calculator3 c1 = new Calculator3();
        Calculator3 c2 = new Calculator3();
        
        c1.plus(2);
        c2.plus(3);
        c1.plus(5);
        c2.multiple(6);
        c1.multiple(3);
        c2.minus(5);
        c1.minus(7);
        c2.plus(11);
        c1.divide(2);
        c2.divide(2);
        System.out.println(c1.result);
        System.out.println(c2.result);

    }

}
