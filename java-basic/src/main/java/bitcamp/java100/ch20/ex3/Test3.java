package bitcamp.java100.ch20.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex3/application_context3.xml");
    }

}
