package bitcamp.java100.ch20.ex15;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex15/application_context1.xml");

        
        Car car = (Car)appCtx.getBean("tico");
        
        System.out.println(car);
        
        System.out.println("------------------------");
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n",name, appCtx.getBean(name));
        }
    }
    
    
}
