package bitcamp.java100.ch21.ex6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex6/application_context1.xml");

        // 어떤 객체가 만들어졌는지 확인
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n",name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------");
        
        // 이름을 모르겠으면 타입으로 찾아라!
        // 타입의 객체가 여러개 있을 때는 이름을 지정해서 찾아라!
        Front obj = (Front) appCtx.getBean(Front.class);
        
        System.out.println(obj.x.getClass().getName());
        
        System.out.println("------------------------");

        obj.test("홍길동");
        
        System.out.println("------------------------");
        
        obj.test(null); // 예외가 발생하는 경
        
    }
    
    
}
