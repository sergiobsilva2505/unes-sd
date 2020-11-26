package com.sbs;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sbs"))
                .paths(regex("/unes-sd.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Unes-SD API Rest",
                "Exemplo exclusivamente didático de uma API Rest",
                "2.0",
                "Termo de Servico",
                new Contact(": Danilo, Diego, João Victor, Mathias, Michelle, Sergio",
                		"https://github.com/sergiobsilva2505/unes-sd",
                        "Sistemas Distribuidos"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
