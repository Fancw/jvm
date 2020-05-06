package xyz.fanchw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FanApp {
    public static void main(String[] args) {
        SpringApplication.run(FanApp.class, args);
    }
}
