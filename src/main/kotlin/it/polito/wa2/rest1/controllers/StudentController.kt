package it.polito.wa2.rest1.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.parameters.RequestBody
import it.polito.wa2.rest1.dtos.StudentDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse
import it.polito.wa2.rest1.dtos.TestDTO
import it.polito.wa2.rest1.services.StudentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@RestController
class StudentController(private val studentService: StudentService) {

    @Operation(
        summary = "Get student by id",
        description = "Returns a JSON description of the specified student given its id"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "The student was properly retrieved"),
            ApiResponse(responseCode = "404", description = "The id was not found")
        ]
    )

    @GetMapping("/students/{id}")
    fun findStudentById(@PathVariable id: Long): StudentDTO = studentService.getStudentById(id)


    //    @GetMapping("/students")
    //    fun findAllStudents(): List<StudentDTO> {
    //        return studentService.getAllStudents()
    //    }

    //    @GetMapping("/students")
    //    fun findAllStudents(): List<StudentDTO> = studentService.getAllStudents()

    @GetMapping("/students")
    fun findAllStudents(@RequestParam surname: String?): List<StudentDTO> {
        if (surname == null)
            return studentService.getAllStudents()
        else return studentService.getAllStudentsBySurname(surname)
    }

    @PostMapping("/test")
    fun test(@RequestBody testDTO: TestDTO):String{
        return studentService.test(testDTO)
    }


}