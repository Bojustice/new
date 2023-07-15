package com.example.piensa.controller
import com.example.piensa.model.Materia
import com.example.piensa.service.MateriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/materia")
class MateriaController {
    @Autowired
    lateinit var materiaService: MateriaService

    @GetMapping
    fun list (materia: Materia, pageable: Pageable): ResponseEntity<*> {
        val response= materiaService.list(pageable, materia)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid materia: Materia): ResponseEntity<Materia> {
        return ResponseEntity(materiaService.save(materia), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody materia: Materia): ResponseEntity<Materia> {
        return ResponseEntity(materiaService.update(materia), HttpStatus.OK)
    }
}