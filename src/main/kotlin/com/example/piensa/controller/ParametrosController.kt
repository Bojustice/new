package com.example.piensa.controller
import com.example.piensa.model.Parametros
import com.example.piensa.service.ParametrosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController

@RequestMapping("/parametros")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ParametrosController {
    @Autowired
    lateinit var parametrosService: ParametrosService

    @GetMapping
    fun list (parametros: Parametros, pageable: Pageable): ResponseEntity<*> {
        val response= parametrosService.list(pageable, parametros)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid parametros: Parametros): ResponseEntity<Parametros> {
        return ResponseEntity(parametrosService.save(parametros), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody parametros: Parametros): ResponseEntity<Parametros> {
        return ResponseEntity(parametrosService.update(parametros), HttpStatus.OK)
    }
}