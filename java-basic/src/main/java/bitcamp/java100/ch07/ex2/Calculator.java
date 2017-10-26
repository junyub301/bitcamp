package bitcamp.java100.ch07.ex2;

public class Calculator {

    int result;
    
    void multiple(int value) {
        this.result *= value;
    }

    void divide(int value) { 
        if (value == 0) {   
            System.err.println("0은 안됩니다.");
            return;
        }
        
        this.result /= value;
    }
    
}
