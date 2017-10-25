package bitcamp.java100.ch07.ex1;

public class Test3 {

    public static void main(String[] args) {
        CalculatorB calc = new CalculatorB();
        calc.result = 1;
        calc.multiple(10);
        calc.multiple(17);
        calc.divide(3);
        calc.remainder(5);

        System.out.println(calc.result);
    }
}
