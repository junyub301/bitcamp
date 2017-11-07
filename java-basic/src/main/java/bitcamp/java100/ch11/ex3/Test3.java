package bitcamp.java100.ch11.ex3;

public class Test3 {

    public static void main(String[] args) {
        
        Truck car = new Truck();
        car.model = "타이탄";
        car.cc = 6000;
        
        car.load(3.8f);
        car.run();
        car.stop();
        car.dump();
    }
}
