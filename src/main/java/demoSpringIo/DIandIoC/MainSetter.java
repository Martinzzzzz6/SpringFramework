package demoSpringIo.DIandIoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Service2 {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Client2 {
    private Service2 service;

    @Autowired
    public void setService(Service2 service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}

@Configuration
class AppConfig2 {
    @Bean
    public Service2 service() {
        return new Service2();
    }

    @Bean
    public Client2 client() {
        Client2 client = new Client2();
        client.setService(service());
        return client;
    }
}

public class MainSetter {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Client2 client = context.getBean(Client2.class);
        client.doSomething();
    }
}
