package com.example.piensa.service
import com.example.piensa.model.Comportamiento
import com.example.piensa.repository.ComportamientoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ComportamientoService {
    @Autowired
    lateinit var comportamientoRepository: ComportamientoRepository

    fun list(): List<Comportamiento>{
        return comportamientoRepository.findAll()
    }

    fun save(comportamiento: Comportamiento): Comportamiento {
        return comportamientoRepository.save(comportamiento)
    }

    fun update(comportamiento: Comportamiento):Comportamiento{
        try{
            comportamientoRepository.findById(comportamiento.id)
                    ?:throw Exception("El id ${comportamiento.id} en comportamiento no existe")
            return comportamientoRepository.save(comportamiento)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, comportamiento: Comportamiento): Page<Comportamiento> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return comportamientoRepository.findAll(Example.of(comportamiento, matcher), pageable)
    }
}