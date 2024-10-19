package dclvs.rso_app_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RsoAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsoAppServerApplication.class, args);
    }

}
