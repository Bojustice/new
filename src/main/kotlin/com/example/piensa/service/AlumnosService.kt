package com.example.piensa.service
import com.example.piensa.model.Alumnos
import com.example.piensa.repository.AlumnosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AlumnosService {
    @Autowired
    lateinit var alumnosRepository: AlumnosRepository

    fun list(): List<Alumnos>{
        return alumnosRepository.findAll()
    }

    fun save(alumnos: Alumnos): Alumnos {
        return alumnosRepository.save(alumnos)
    }

    fun update(alumnos: Alumnos): Alumnos {
        try{
            alumnosRepository.findById(alumnos.id)
                    ?:throw Exception("El id ${alumnos.id} en alumnos no existe")
            return alumnosRepository.save(alumnos)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, alumnos: Alumnos): Page<Alumnos> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return alumnosRepository.findAll(Example.of(alumnos, matcher), pageable)
    }
}