package bitcamp.java100.ch20.ex10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex10/application_context1.xml");

        
        Car car = (Car)appCtx.getBean("c1");
        
        System.out.println(car);
    }
    
    
}
