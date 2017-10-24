package bitcamp.java100.ch06.ex4;

public class Test2 {
    
    static int plus(int a, int b) {return a + b;} 
    static int minus(int a, int b) {return a - b;}
    static int multiple(int a, int b) {return a * b;}
    static int divide(int a, int b) {return a / b;}
   
    public static void main(String[] args) {
    
        int result = 0;
        
        result = plus(2, 5);
        result = multiple(result, 3);
        result = minus(result, 7);
        result = divide(result, 2);
        
        System.out.println(result);
        
    }
    
}
