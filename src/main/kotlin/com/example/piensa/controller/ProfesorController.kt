package com.example.piensa.controller
import com.example.piensa.model.Profesor
import com.example.piensa.service.ProfesorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController

@RequestMapping("/profesor")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ProfesorController {
    @Autowired
    lateinit var profesorService: ProfesorService

    @GetMapping
    fun list (profesor: Profesor,pageable: Pageable):ResponseEntity<*>{
        val response= profesorService.list(pageable, profesor)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody profesor:Profesor): ResponseEntity<Profesor>{
        return ResponseEntity(profesorService.save(profesor), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody profesor:Profesor): ResponseEntity<Profesor>{
        return ResponseEntity(profesorService.update(profesor), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody profesor: Profesor):ResponseEntity<Profesor>{
        return ResponseEntity(profesorService.updateNombres(profesor), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return profesorService.delete(id)
    }
}