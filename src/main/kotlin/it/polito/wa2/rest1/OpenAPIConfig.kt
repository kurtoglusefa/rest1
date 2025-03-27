package it.polito.wa2.rest1

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenAPIConfig {
    @Bean
    fun getOpenApiDocumentation(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Student API")
                .description("Using this API you can get information about students")
                .version("v1.0")
                .contact(Contact().name("<NAME>").email("student@email.com"))
            //many more properties can be set
        )
}

