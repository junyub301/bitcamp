package java100.app;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java100.app.util.DataSource;



// 이 클래스가 스프링 IoC 컨테이너를 위한 설정 클래스임을 표시
@Configuration 
// @Component가 붙은 클래스가 어느 패키지에 있는지 표시
@ComponentScan("java100.app")
public class AppConfig {

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

}






