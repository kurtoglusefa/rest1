package it.polito.wa2.rest1.controllers


import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.net.URI
import kotlin.reflect.KClass


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

    @Constraint(validatedBy = [StrongPasswordValidator::class])
    @Target(AnnotationTarget.FIELD)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class StrongPassword(
        val message: String = "Weak password!",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<*>> = []
    )

    class StrongPasswordValidator : ConstraintValidator<StrongPassword?, String?> {
        override fun isValid(password: String?, context: ConstraintValidatorContext?): Boolean {
//            if (value == null) {
//                return false
//            }
//            val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")
//            return regex.matches(value)
            return password != null &&
                    password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$".toRegex())
        }
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun noSuchElementException(ex: NoSuchElementException): ProblemDetail {
        return ProblemDetail.forStatus(HttpStatus.NOT_FOUND).apply {
            title = "Student not found"
            detail = ex.message
            type = URI.create("https://example.it/problem/student-not-found")
        }
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(ex: ConstraintViolationException): ProblemDetail {
        return ProblemDetail.forStatus(HttpStatus.BAD_REQUEST).apply {
            title = "Bad Request"
            detail = "Invalid request content."
            type = URI.create("about:blank")
            instance = URI.create("/test")
            this.properties?.set("test.testDTO.password", "weak password!")
        }
    }
}