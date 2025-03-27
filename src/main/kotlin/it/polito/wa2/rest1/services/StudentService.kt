package it.polito.wa2.rest1.services

import it.polito.wa2.rest1.dtos.StudentDTO

interface StudentService {
    fun getStudentById(id: Long): StudentDTO
    fun getAllStudents(): List<StudentDTO>
    fun getAllStudentsBySurname(surname: String): List<StudentDTO>
    //fun addStudent(student: StudentDTO): StudentDTO
    //fun updateStudent(id: Long, student: StudentDTO): StudentDTO
    //fun deleteStudent(id: Long)

}