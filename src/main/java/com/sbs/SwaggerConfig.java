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
                .apis(RequestHandlerSelectors.basePackage("com.sbs")) // .basePackage("com.sbs")
                .paths(regex("/unes-sd.*")) // regex("/unes-sd.*")
                .build()
                .apiInfo(metaInfo()); // metaInfo()
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo =new ApiInfo(
                "Unes-SD API Rest", // Nome da API
                "Exemplo exclusivamente didático de uma API Rest", // Descrição
                "2.0", // Versão
                "www.google.com", // URL Termo de Servico
                new Contact(": Danilo, Diego, João Victor, Mathias, Michelle, Sergio",
                		"https://github.com/sergiobsilva2505/unes-sd",
                        "sergiosilva.5017@aluno.saojudas.br"), // Contato
                "Apache License Version 2.0", // Licença
                "http://www.apache.org/licenses/LICENSE-2.0", // URL de licença
                new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
