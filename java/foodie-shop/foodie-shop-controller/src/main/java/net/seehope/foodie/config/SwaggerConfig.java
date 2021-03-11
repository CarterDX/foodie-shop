package net.seehope.foodie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createDocument() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("net.seehope")).build();
    }

    public ApiInfo createApiInfo() {
        return new ApiInfoBuilder().contact(new Contact("mt", "http://www.mtproject.cn", "249415779@qq.com"))
            .description("天天吃货商城").title("天天吃货商城API文档").version("0.0.1").termsOfServiceUrl("http://www.mtproject.cn")
            .build();
    }
}
