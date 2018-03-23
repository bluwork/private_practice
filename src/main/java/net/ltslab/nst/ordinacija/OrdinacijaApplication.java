package net.ltslab.nst.ordinacija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OrdinacijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdinacijaApplication.class, args);
    }
}
