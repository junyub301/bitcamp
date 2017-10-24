package bitcamp.java100.ch06.ex6;

public class Test2 {

    public static void main(String[] args) {
        Car2[] cars = new Car2[6];
        
        cars[0] = new Car2("티코", 900, 3, 2);
        cars[1] = new Car2("티코", 900, 2, 1);
        cars[2] = new Car2("티코", 900, 1, 3);

        cars[3] = new Car2("소나타", 1980, 1, 1);
        cars[4] = new Car2("소나타", 1980, 2, 2);
        cars[5] = new Car2("소나타", 1980, 3, 3);
        
        System.out.printf("총 생산량 = %d대\n", Car2.count);
        
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%d, %s, %d\n",cars[i].no, cars[i].model, cars[i].cc);
        }
        
        
    }
}
