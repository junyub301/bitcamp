package bitcamp.java100.ch11.ex4;

public class HybridCar extends Car {

        
        int charge;
        int speed;
        
        public void running() {
            if (speed < 100)
                System.out.println("전기모터로 움직인다.");
            else
                System.out.println("엔진으로 움직인다.");
        }


}
