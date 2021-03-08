package top.szz.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@EnableOpenApi
public class SpringBootBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }


}