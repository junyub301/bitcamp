package bitcamp.java100.ch06;

public class Test1 {

    public static void main(String[] args) {
        
        // Car car = new Car(); -> 컴파일 오류
        
        Sedan car1 = new Sedan();
        car1.run();
        car1.stop();
        
        Truck car2 = new Truck();
        car2.run();
        car2.stop();
    }
}
