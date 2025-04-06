package it.polito.wa2.rest1.services

import it.polito.wa2.rest1.dtos.StudentDTO
import it.polito.wa2.rest1.dtos.TestDTO
import org.springframework.stereotype.Service

@Service("mock")
class StudentServiceMock : StudentService {
    private val students = mutableListOf(
        StudentDTO(1, "Mario", "Rossi", "s1@email.com"),
        StudentDTO(2, "Maria", "Bianchi", "s2@email.com"),
    )

    override fun getAllStudents(): List<StudentDTO> {
        return students
    }

    override fun getStudentById(id: Long): StudentDTO {
        students.find { it.id == id }?.let { return it }
            ?: throw NoSuchElementException("Student $id not found")
    }

    override fun getAllStudentsBySurname(surname: String): List<StudentDTO> {
        return students.filter { it.surname == surname }
    }
    override fun test(testDTO: TestDTO): String {
        // Implement the logic for the test method here
        return "Test method implementation in mock"
    }
}