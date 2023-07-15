package com.example.piensa.repository
import com.example.piensa.model.Parametros
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ParametrosRepository: JpaRepository<Parametros, Long> {
    fun findById(id: Long?): Parametros?
}