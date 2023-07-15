package com.example.piensa.controller
import com.example.piensa.model.Profesor
import com.example.piensa.service.ProfesorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/profesor")
class ProfesorController {
    @Autowired
    lateinit var profesorService: ProfesorService

    @GetMapping
    fun list (profesor: Profesor,pageable: Pageable):ResponseEntity<*>{
        val response= profesorService.list(pageable, profesor)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid profesor:Profesor): ResponseEntity<Profesor>{
        return ResponseEntity(profesorService.save(profesor), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody profesor:Profesor): ResponseEntity<Profesor>{
        return ResponseEntity(profesorService.update(profesor), HttpStatus.OK)
    }
}