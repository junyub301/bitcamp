package java100.app;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java100.app.util.DataSource;

//01026344150
//jinyoun.eom@gmail.com


@WebServlet(urlPatterns="/init",name="AppInitServlet", loadOnStartup=1)
// 이 클래스가 스프링 IoC 컨테이너를 위한 설정 클래스임을 표시
@Configuration 
// @Component가 붙은 클래스가 어느 패키지에 있는지 표시
@ComponentScan("java100.app")
public class AppInitServlet implements Servlet {

    ServletConfig servletConfig;

    public static AnnotationConfigApplicationContext iocContainer;

    // 스프링 IoC 컨테이너에게 getDataSource() 메서드를 호출해서
    // 이 메서드가 리턴한 객체를 꼭 컨테이너에 보관해달라고 표시!
    @Bean
    DataSource getDataSource() {

        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        return ds;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        System.out.println("AppInitServelt.init()");

        this.servletConfig = config;

        // @Bean이 붙은 메서드의 리턴값을 다 저장하고, @Component가 있는클래스를 다 찾는다.
        iocContainer = new AnnotationConfigApplicationContext(AppInitServlet.class);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("AppInitServelt.service()");

    }

    @Override
    public void destroy() {
        System.out.println("AppInitServelt.destroy()");
        
        DataSource ds = iocContainer.getBean(DataSource.class);
        ds.close();
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return "이 서블릿은 다른 서블릿을 위한 스프링 IoC 컨테이너를 준비한다.";
    }
}






