package bitcamp.java100.ch06.ex4;

public class Test6 {

    public static void main(String[] args) {

        Calculator2 calculator2 = new Calculator2();
        Calculator2 c2 = new Calculator2();
        
        Calculator2.plus(calculator2, 2);
        Calculator2.plus(calculator2, 5);
        Calculator2.multiple(calculator2, 3);
        Calculator2.minus(calculator2, 7);
        Calculator2.divide(calculator2, 2);
        System.out.println(calculator2.result);

        Calculator2.plus(c2, 3);
        Calculator2.multiple(c2, 6);
        Calculator2.minus(c2, 5);
        Calculator2.plus(c2, 11);
        Calculator2.divide(c2, 2);
        System.out.println(c2.result);
    }

}
