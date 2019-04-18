package com.rackspace.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket rewardsDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("demo-service")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rackspace.example.demo"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("demo-randomNumberGenerator")
                .description("This is a demo service. The service has one operation - to get Random Number.")
                .contact(new Contact("", "", "abcd@abcd.com"))
                .license("Demo Purpose Only")
                .version("1.0.0")
                .build();
    }

}
