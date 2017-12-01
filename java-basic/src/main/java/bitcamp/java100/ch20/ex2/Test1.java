package bitcamp.java100.ch20.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex2/application_context1.xml");
        
        System.out.printf("빈 개수 = %d\n", appCtx.getBeanDefinitionCount());
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s\n  클래스명: %s\n", name, appCtx.getBean(name).getClass().getName());
            
            // 지정된 객체에 별명이 있으면 가져오기
            String[] aliases = appCtx.getAliases(name);
            System.out.print("  별명: ");
            for (String alias : aliases) {
                System.out.print(alias + ",");
            }
            System.out.println();
        }
        
    }

}
