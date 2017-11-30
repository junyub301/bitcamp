package bitcamp.java100.ch20.ex1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test4 {
    
    @Bean("str1")
    String getString1() {
        return new String();
    }

    @Bean("str2")
    String getString2() {
        return new String("Hello!");
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appCtx = 
                new AnnotationConfigApplicationContext(Test4.class);
        
        System.out.printf("빈 개수 = %d\n", appCtx.getBeanDefinitionCount());
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s\n      ----> %s\n", name, appCtx.getBean(name).getClass().getName());
        }
        
        System.out.println("--------------------------------");
        
        String s1 = (String) appCtx.getBean("str1"); 
        String s2 = (String) appCtx.getBean("str2");
        
        System.out.println(s1);
        System.out.println(s2);
    }

}
