package bitcamp.java100.ch11.ex4;

import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        
        HybridCar car = new HybridCar();
        car.model = "비트하이드로";
        car.cc = 3000;
        
        car.run();
        car.stop();
        
        car.speed = 80;
        car.running();
        car.stop();
        
        car.speed = 120;
        car.running();
        car.stop();
        
        ArrayList<Car> carTestCenter = new ArrayList<>();
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 900;
        carTestCenter.add(car1);

        Truck car2 = new Truck();
        car2 .model = "타이탄";
        car2.cc = 5000;
        carTestCenter.add(car2);
    }
}
