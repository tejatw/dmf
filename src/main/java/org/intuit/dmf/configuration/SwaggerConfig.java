package org.intuit.dmf.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("org.intuit.dmf"))
                .paths(PathSelectors.regex("/v.*"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    @SuppressWarnings({ "deprecation" })
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Entity API", "API for Entities", "1.0", "", "", "", "");
        return apiInfo;
    }

}






