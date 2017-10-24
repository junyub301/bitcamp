package bitcamp.java100.ch06.ex6;

public class Car {
    static int count;
    long no;
    String model;
    int cc;

    Car(String model, int cc) {
        count++;
        this.model = model;
        this.cc = cc;
        this.no = System.currentTimeMillis();
        
        try {
            Thread.currentThread().sleep(50);
        } catch (Exception e) {}
    }
}
