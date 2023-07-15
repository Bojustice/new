package com.example.piensa.service
import com.example.piensa.model.Parametros
import com.example.piensa.repository.ParametrosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ParametrosService {
    @Autowired
    lateinit var parametrosRepository: ParametrosRepository

    fun list(): List<Parametros>{
        return parametrosRepository.findAll()
    }

    fun save(parametros: Parametros): Parametros {
        return parametrosRepository.save(parametros)
    }

    fun update(parametros: Parametros):Parametros{
        try{
            parametrosRepository.findById(parametros.id)
                    ?:throw Exception("El id ${parametros.id} en parametros no existe")
            return parametrosRepository.save(parametros)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, parametros: Parametros): Page<Parametros> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return parametrosRepository.findAll(Example.of(parametros, matcher), pageable)
    }
}