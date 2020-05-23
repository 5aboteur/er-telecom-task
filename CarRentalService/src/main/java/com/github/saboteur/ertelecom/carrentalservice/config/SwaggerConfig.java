package com.github.saboteur.ertelecom.carrentalservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {

    final String API_VERSION = "v1";

    @Bean
    Docket api() {
        ApiInfo info = new ApiInfo(
            "Car Rental Service API",
            "This service automates car rental processes",
            API_VERSION,
            ApiInfo.DEFAULT.getTermsOfServiceUrl(),
            ApiInfo.DEFAULT.getContact(),
            ApiInfo.DEFAULT.getLicense(),
            ApiInfo.DEFAULT.getLicenseUrl(),
            ApiInfo.DEFAULT.getVendorExtensions()
        );

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(info)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }

}
