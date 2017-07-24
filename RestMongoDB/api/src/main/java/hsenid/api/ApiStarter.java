package hsenid.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hsenid.domain", "hsenid.api.controllers", "hsenid.api.repository"})
public class ApiStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApiStarter.class);
    }
}
