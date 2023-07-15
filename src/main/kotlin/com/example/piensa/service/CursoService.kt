package com.example.piensa.service
import com.example.piensa.model.Curso
import com.example.piensa.repository.CursoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CursoService {
    @Autowired
    lateinit var cursoRepository: CursoRepository

    fun list(): List<Curso>{
        return cursoRepository.findAll()
    }

    fun save(curso: Curso): Curso {
        return cursoRepository.save(curso)
    }

    fun update(curso: Curso):Curso{
        try{
            cursoRepository.findById(curso.id)
                ?:throw Exception("El id ${curso.id} en curso no existe")
            return cursoRepository.save(curso)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, curso: Curso): Page<Curso> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return cursoRepository.findAll(Example.of(curso, matcher), pageable)
    }
}