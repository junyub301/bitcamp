package bitcamp.java100.ch06.ex4;

public class Test3 {
    
    static int result;
    
    static void plus(int value) {result += value;} 
    static void minus(int value) {result -= value;}
    static void multiple(int value) {result *= value;}
    static void divide(int value) {result /= value;}
   
    public static void main(String[] args) {
    
        
        plus(2);
        plus(5);
        multiple(3);
        minus(7);
        divide(2);
        
        System.out.println(result);
        
    }
    
}
