package java100.app.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java100.app.annotation.RequestMappingHandlerMapping;
import java100.app.util.DataSource;

public class ContextLoaderListener implements ServletContextListener {

    public static AnnotationConfigApplicationContext iocContainer;
    public static RequestMappingHandlerMapping handlerMapping;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행");
        ServletContext webApplicationInfo = sce.getServletContext();
        String configClassName = webApplicationInfo.getInitParameter("contextConfigLocation");

        try {
            // 클래스 이름으로 클래스 정보를 다루는 객체를 얻는다.
            Class<?> configClass = Class.forName(configClassName);

            // 웹 애플리케이션이 시작될 때 AppConfig클래스에 설정된 대로 Spring IoC 컨테이너를 준비한다.
            // @Bean이 붙은 메서드의 리턴값을 다 저장하고, @Component가 있는클래스를 다 찾는다.
            iocContainer = new AnnotationConfigApplicationContext(configClass);
            
            // 스프링 IoC 컨테이너에 들어있는 페이지 컨트롤러를 찾는다.
            // 그리고 페이지 컨트롤러에서 요청 핸들러를 찾아 맵을 구성한다.
            // 이렇게 구성된 맵은 프론트 컨트롤러가 사용할 것이다.
            handlerMapping = new RequestMappingHandlerMapping(iocContainer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // 웹 애플리케이션이 종료될떄 DB 커넥션 풀에 저장된 모든 커넥션을 닫는다.
        DataSource ds = iocContainer.getBean(DataSource.class);
        ds.close();
    }


}
