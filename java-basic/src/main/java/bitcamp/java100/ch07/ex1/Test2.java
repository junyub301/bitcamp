package bitcamp.java100.ch07.ex1;

public class Test2 {

    public static void main(String[] args) {
        CalculatorA calc = new CalculatorA();
        calc.plus(10);
        calc.plus(20);
        calc.minus(7);
        calc.multiple(2);
        calc.divide(3);
        System.out.println(calc.result);
    }
}
