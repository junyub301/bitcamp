package bitcamp.java100.ch11.ex6;

public class Test2 {

    public static void main(String[] args) {

        B obj = new B();
        obj.m1();
        obj.m2();
        
        System.out.println("----------------------------------------------");
        A obj2 = new B();
        obj2.m1();
//        obj2.m2(); -> 컴파일 오류
    
        ((B)obj2).m2();
    }

}
