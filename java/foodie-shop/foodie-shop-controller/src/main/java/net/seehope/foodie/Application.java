package net.seehope.foodie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

//@ComponentScan(basePackages = {"net.seehope.foodie"})
@MapperScan("net.seehope.**.mapper")
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
@EnableScheduling
@EnableAsync
@EnableSwagger2
@ComponentScan(basePackages = { "org.n3r.idworker", "net.seehope.foodie" })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
