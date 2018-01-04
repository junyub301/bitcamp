package bitcamp.java100.ch21.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex3/application_context1.xml");

        // 어떤 객체가 만들어졌는지 확인
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n",name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------");
        
        // 이름을 모르겠으면 타입으로 찾아라!
        // 타입의 객체가 여러개 있을 때는 이름을 지정해서 찾아라!
        Front obj = (Front) appCtx.getBean(Front.class);
        obj.test("홍길동");
        System.out.println("------------------------");
        
        obj.test(null); // 예외가 발생하는 경
        
        // advice 적용 위치
        // Before
        //  => 메서드를 호출하기 전에 실행한다.
        // AfterReturning
        //  => 리턴 값을 호출자에게 전달하기 위해 저장한 후에 실행한다.
        // After
        //  => 리턴 할 값이 있으면 호출자에게 리턴한 후, 메서드 호출을 종료한 후에 실행한다.
        // AfterThrowing
        //  => 예외가 발생하여 메서드 호출이 끝난 후, catch {} 블럭으로 이동하기 전에 싫애한다.
        
        // Before ==> AfterReturing ==> After => (AfterThrowing)
        
    }
    
    
}
