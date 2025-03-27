package it.polito.wa2.rest1.controllers


import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.net.URI


//@ControllerAdvice
//@ResponseBody
//class StudentAdvice: ResponseEntityExceptionHandler() {
//    @ExceptionHandler(NoSuchElementException::class)
//    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
//    fun handleInvalidUrlException(ex: NoSuchElementException): ErrorMessage {
//        return ErrorMessage(ex.message ?: "No such element found")
//    }
//}

@RestControllerAdvice
class StudentAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NoSuchElementException::class)
    fun noSuchElementException(ex: NoSuchElementException): ProblemDetail {
        return ProblemDetail.forStatus(HttpStatus.NOT_FOUND).apply {
            title = "Student not found"
            detail = ex.message
            type = URI.create("https://example.it/problem/student-not-found")
        }
    }
}

//data class ErrorMessage(val message: String)