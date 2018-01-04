package bitcamp.java100.ch21.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex2/application_context5.xml");

        // 어떤 객체가 만들어졌는지 확인
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n",name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------");
        
        // 이름을 모르겠으면 타입으로 찾아라!
        // 타입의 객체가 여러개 있을 때는 이름을 지정해서 찾아라!
        Front obj = (Front) appCtx.getBean(Front.class);
        obj.test();
        
        // 작업순서
        // 0) AOP 관련 라이브러리 가져오기
        //    - aspectj weaver라이브러리 가져오기
        // 1) Advice를 수행할 클래스를 만든다.
        // 2) XML 설정파일에 코드 삽입 정보를 지정한다.
        
        
    }
    
    
}
