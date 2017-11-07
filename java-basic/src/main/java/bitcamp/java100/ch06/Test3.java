package bitcamp.java100.ch06;

import java.util.ArrayList;

public class Test3 {

    public static void main(String[] args) {
        
        
        ArrayList<Car> carTestCenter = new ArrayList<>();
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 900;
        
        carTestCenter.add(car1);

        Truck car2 = new Truck();
        car2 .model = "타이탄";
        car2.cc = 5000;
        
        carTestCenter.add(car2);
        
        HybridCar car3 = new HybridCar();
        car3.model = "비트하이드로";
        car3.cc = 2000;
        
        carTestCenter.add(car3);
        
        for (Car car : carTestCenter) {
            System.out.printf("모델명: %s\n", car.model);
            System.out.printf("cc: %d\n", car.cc);
            car.run();
            car.stop();
        }
    }
}
