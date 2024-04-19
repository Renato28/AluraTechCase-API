package br.com.alura.api.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Alura-Tech-Case API")
                        .description("\n" +
                                "Rest API of the Alura-Tech-Case application, containing the functions of register a user, list users, register a course, inactivating a course, list courses and register a user")
                        .contact(new Contact()
                                .name("Renato Nobrega")
                                .email("renatonobrega87@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://aluratechcase/api/licenca")));
    }


}