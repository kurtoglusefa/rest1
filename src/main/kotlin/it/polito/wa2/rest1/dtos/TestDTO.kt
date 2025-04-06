package it.polito.wa2.rest1.dtos

import it.polito.wa2.rest1.controllers.StudentAdvice
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated

@Validated
data class TestDTO(
    @field:NotBlank
    val name: String,
    //@field:Size(min = 8)
    @field:StudentAdvice.StrongPassword
    val password: String
)
