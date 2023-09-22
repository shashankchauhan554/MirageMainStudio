package com.stackroute.SalonOwnerService.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalonConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().addSecurityItem(new SecurityRequirement()
                        .addList("Bearer Authentication")).components(new Components()
                        .addSecuritySchemes("Bearer Authentication",createAPIKeyScheme()))
                .info(new Info().title("Admin RESTFUL API").description("List of all the Rest API")
                        .version("1.0").contact(new Contact().name("stay planner")
                                .email("planner@gmail.com").url("www.fr.com"))
                        .license(new License().name("License to Stackroute")));

    }
    private SecurityScheme createAPIKeyScheme(){
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT").scheme("bearer");
    }
}
