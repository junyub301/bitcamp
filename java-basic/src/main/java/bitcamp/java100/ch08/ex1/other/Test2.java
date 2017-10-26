package bitcamp.java100.ch08.ex1.other;

import bitcamp.java100.ch08.ex1.A;

public class Test2 {

    public static void main(String[] args) {

        // private 멤버
        // A.v1 = 100; 접근불가
        
        // (default) 멤버
        // A.v2 = 200; 접근불가
        
        // protected 멤버
        // A.v3 = 300; 접근불가
        
        // public 멤버
        A.v4 = 400;
    }

}
