package bitcamp.java100.ch20.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex2/application_context4.xml");
    }

}
