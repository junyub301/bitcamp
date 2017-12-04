package bitcamp.java100.ch20.ex6;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {

    public static Car createCar(String model) {
        switch (model) {
        case "티코": return createTico();
        case "티코 콜드": return createTicoGole();
        case "소나다": return createSonata();
        case "에쿠스": return createEquus();
        default: return createBasic();
        }
    }

    private static Car createBasic() {
        Car c = new Car();

        Engine engine = new Engine();
        engine.setCc(1500);
        engine.setName("비트엔진");
        engine.setValve(16);

        c.setEngine(engine);
        return c;
    }

    private static Car createEquus() {
        Car c = new Car();

        Engine engine = new Engine();
        engine.setCc(3500);
        engine.setName("비트스페셜엔진");
        engine.setValve(32);

        c.setEngine(engine);
        return c;
    }

    private static Car createSonata() {
        Car c = new Car();

        Engine engine = new Engine();
        engine.setCc(1980);
        engine.setName("비트표준엔진");
        engine.setValve(16);

        c.setEngine(engine);
        return c;
    }

    private static Car createTicoGole() {
        Car c = new Car();

        Engine engine = new Engine();
        engine.setCc(900);
        engine.setName("비트엔진");
        engine.setValve(16);

        c.setEngine(engine);

        Map<String, String> options = new HashMap<>();
        options.put("sunfoor", "yes");
        options.put("airbag", "yes");
        options.put("blackbox", "yes");

        c.setOptions(options);

        return c;
    }

    private static Car createTico() {
        Car c = new Car();

        Engine engine = new Engine();
        engine.setCc(900);
        engine.setName("비트엔진");
        engine.setValve(16);

        c.setEngine(engine);
        return c;
    }
}
