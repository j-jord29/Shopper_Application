package Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Component("configBean")
public class AppConfig {

    @Bean
    public AppConfig configBean() {
        return new AppConfig();
    }

    @Bean
    public String test() {
        return "OK";
    }
}
