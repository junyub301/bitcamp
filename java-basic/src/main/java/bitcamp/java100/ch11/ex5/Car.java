package bitcamp.java100.ch11.ex5;

public abstract class Car {
    String model;
    int cc;
    
    public void stop() {
        System.out.println("멈춘다.");
    }
    public abstract void run();
}
