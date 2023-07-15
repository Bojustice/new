package com.example.piensa.service
import com.example.piensa.model.Materia
import com.example.piensa.repository.MateriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MateriaService {
    @Autowired
    lateinit var materiaRepository: MateriaRepository

    fun list(): List<Materia>{
        return materiaRepository.findAll()
    }

    fun save(materia: Materia): Materia {
        return materiaRepository.save(materia)
    }

    fun update(materia: Materia):Materia{
        try{
            materiaRepository.findById(materia.id)
                    ?:throw Exception("El id ${materia.id} en materia no existe")
            return materiaRepository.save(materia)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, materia: Materia): Page<Materia> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return materiaRepository.findAll(Example.of(materia, matcher), pageable)
    }
}