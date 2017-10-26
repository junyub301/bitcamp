package bitcamp.java100.ch07.ex3.before;

public class Test1 {

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
