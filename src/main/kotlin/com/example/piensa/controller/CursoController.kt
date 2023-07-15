package com.example.piensa.controller
import com.example.piensa.model.Curso
import com.example.piensa.service.CursoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/curso")
class CursoController {
    @Autowired
    lateinit var cursoService: CursoService

    @GetMapping
    fun list (curso: Curso, pageable: Pageable): ResponseEntity<*> {
        val response= cursoService.list(pageable, curso)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid curso: Curso): ResponseEntity<Curso> {
        return ResponseEntity(cursoService.save(curso), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody curso: Curso): ResponseEntity<Curso> {
        return ResponseEntity(cursoService.update(curso), HttpStatus.OK)
    }
}