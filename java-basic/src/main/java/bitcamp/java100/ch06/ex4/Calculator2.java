package bitcamp.java100.ch06.ex4;

public class Calculator2 {

    int result;

    static void plus(Calculator2 that, int value) {that.result += value;} 
    static void minus(Calculator2 that, int value) {that.result -= value;}
    static void multiple(Calculator2 that, int value) {that.result *= value;}
    static void divide(Calculator2 that, int value) {that.result /= value;}

}
