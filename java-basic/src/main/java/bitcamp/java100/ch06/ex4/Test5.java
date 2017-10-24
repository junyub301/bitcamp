package bitcamp.java100.ch06.ex4;

public class Test5 {

    public static void main(String[] args) {

        Calculator1.plus(2);
        Calculator1.plus(5);
        Calculator1.multiple(3);
        Calculator1.minus(7);
        Calculator1.divide(2);
        System.out.println(Calculator1.result);

        Calculator1.result = 0;
        Calculator1.plus(3);
        Calculator1.multiple(6);
        Calculator1.minus(5);
        Calculator1.plus(11);
        Calculator1.divide(2);
        System.out.println(Calculator1.result);
    }

}
