package net.seehope.foodie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

//@ComponentScan(basePackages = {"net.seehope.foodie"})
@MapperScan("net.seehope.**.mapper")
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableSwagger2
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
