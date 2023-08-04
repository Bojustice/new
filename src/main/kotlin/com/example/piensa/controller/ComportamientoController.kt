package com.example.piensa.controller
import com.example.piensa.model.Comportamiento
import com.example.piensa.service.ComportamientoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController

@RequestMapping("/comportamiento")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ComportamientoController {
    @Autowired
    lateinit var comportamientoService: ComportamientoService

    @GetMapping
    fun list (comportamiento: Comportamiento, pageable: Pageable): ResponseEntity<*> {
        val response= comportamientoService.list(pageable, comportamiento)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid comportamiento: Comportamiento): ResponseEntity<Comportamiento> {
        return ResponseEntity(comportamientoService.save(comportamiento), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody comportamiento: Comportamiento): ResponseEntity<Comportamiento> {
        return ResponseEntity(comportamientoService.update(comportamiento), HttpStatus.OK)
    }
}