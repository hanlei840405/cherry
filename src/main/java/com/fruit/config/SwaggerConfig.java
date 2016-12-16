package com.fruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by hanlei6 on 16-12-14.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerPlugin() {
        return new Docket(DocumentationType.SPRING_WEB).groupName("cherry").
                genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).
                forCodeGeneration(false).pathMapping("/").select().build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Jesse.Han", "https://github.com/hanlei840405", "hanlei.840405@gmail.com");
        ApiInfo apiInfo = new ApiInfo("cherry's api", "rest", "0.0.1-SNAPSHOT", "https://github.com/hanlei840405", contact, "index", "");
        return apiInfo;
    }
}
