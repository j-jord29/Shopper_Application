package Test;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanExample {
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public ServiceBean serviceBean() {
        return new ServiceBean();
    }

    @Bean
    public ClientBean1 ClientBean1() {
        return new ClientBean1();
    }

    @Bean
    public ClientBean2 ClientBean2() {
        return new ClientBean2();
    }

    public static void main(String[] args) {
        //ApplicationContext context = SpringApplication.run(BeanExample.class,args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanExample.class);
        ctx.getBean(ClientBean1.class).printBean();
        ctx.getBean(ClientBean2.class).printBean();

    }

}


