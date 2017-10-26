package bitcamp.java100.ch08.ex2;

public class Test1 {

    public static void main(String[] args) {
        Vehicle v;
        v = new Vehicle();
        v = new Boat();
        v = new Car();
        v = new Truck();
        v = new Sedan();
        
        Boat b;
        b = new Boat();
//        b = new Vehicle(); -> 하위분류로 상위분류를 가리킬 수 없다.
//        b = new Car(); -> 다른 파생 분류를 가리킬수 없다.
//        b = new Truck(); -> 다른 파생 분류를 가리킬 수 없다.
//        b = new Sedan(); -> 다른 파생 분류를 가리킬 수 없다.
        
        Car c;
        c = new Car();
        c = new Truck();
        c = new Sedan();
//        c = new Boat(); -> 다른 파생 분류를 가리킬 수 없다.
//        c = new Vehicle(); -> 상위 분류를 가리킬 수 없다.
        
        Sedan s;
        s = new Sedan();
//        s = new Truck();
//        s = new Car();
//        s = new Boat();
//        s = new Vehicle();
    }



}
