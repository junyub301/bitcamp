package bitcamp.java100.ch11.ex3;

public class Truck extends Car {

    float weight;
    
    @Deprecated
    public void move() {
        this.run();
    }
    
    @Override
    public void run() {
        System.out.println("간다.");
    }
    
    public void dump() {
        weight = 0f;
        System.out.printf("물건을 내린다. (%.1f톤)\n", this.weight);
        
    }

    public void load(float weight) {
        this.weight = weight;
        System.out.printf("물건을 싣는다. (%.1f톤)\n", this.weight);
    }
}

