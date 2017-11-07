package bitcamp.java100.ch11.ex2;

public class Test2 {

    public static void main(String[] args) {
        
        Truck car = new Truck();
        car.model = "타이탄";
        car.cc = 5000;
        
        car.load(3.8f);
        car.move();
        car.stop();
        car.dump();
    }
}
