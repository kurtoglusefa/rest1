package it.polito.wa2.rest1.services

import it.polito.wa2.rest1.dtos.StudentDTO
import it.polito.wa2.rest1.dtos.TestDTO
import it.polito.wa2.rest1.dtos.toDTO
import it.polito.wa2.rest1.repositories.StudentRepository
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Primary
class StudentServiceImpl(private val studentRepository: StudentRepository): StudentService {
    override fun getStudentById(id: Long): StudentDTO {
        val student = studentRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Student $id not found")
        return student.toDTO()
    }

    override fun getAllStudents(): List<StudentDTO> {
        return studentRepository.findAll().map { it.toDTO() }
    }

    override fun getAllStudentsBySurname(surname: String): List<StudentDTO> {
        return studentRepository.findAllBySurname(surname).map { it.toDTO() }
    }

    override fun test(testDTO: TestDTO): String {
        // Implement the logic for the test method here
        return "Test method implementation"
    }
}