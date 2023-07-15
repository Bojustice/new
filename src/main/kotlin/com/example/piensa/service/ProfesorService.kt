package com.example.piensa.service
import com.example.piensa.model.Profesor
import com.example.piensa.repository.ProfesorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProfesorService {
    @Autowired
    lateinit var profesorRepository: ProfesorRepository

    fun list(): List<Profesor>{
        return profesorRepository.findAll()
    }

    fun save(profesor:Profesor): Profesor {
        return profesorRepository.save(profesor)
    }

    fun update(profesor:Profesor):Profesor{
        try{
            profesorRepository.findById(profesor.id)
                    ?:throw Exception("El id ${profesor.id} en profesores no existe")
            return profesorRepository.save(profesor)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, profesor: Profesor): Page<Profesor>{
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return profesorRepository.findAll(Example.of(profesor, matcher), pageable)
    }
}