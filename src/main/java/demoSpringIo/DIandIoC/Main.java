package demoSpringIo.DIandIoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Client {
    private final Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}

@Configuration
class AppConfig {
    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public Client client() {
        return new Client(service());
    }
}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Client client = context.getBean(Client.class);
        client.doSomething();
    }
}
