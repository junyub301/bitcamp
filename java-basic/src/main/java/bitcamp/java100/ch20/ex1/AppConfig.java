package bitcamp.java100.ch20.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean("str1")
    String getString1() {
        return new String();
    }

    @Bean("str2")
    String getString2() {
        return new String("Hello!");
    }
}
