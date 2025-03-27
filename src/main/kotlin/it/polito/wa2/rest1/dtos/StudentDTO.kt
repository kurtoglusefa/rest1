package it.polito.wa2.rest1.dtos

import it.polito.wa2.rest1.entities.Student

data class StudentDTO(
    val id: Long,
    val name: String,
    val surname: String,
    val email: String
)

fun Student.toDTO() = StudentDTO(this.id, this.name, this.surname, "s${this.id}@student.email.com")