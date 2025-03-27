package it.polito.wa2.rest1.repositories

import it.polito.wa2.rest1.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student,Long> {
    fun findAllBySurname(surname: String): List<Student>

}