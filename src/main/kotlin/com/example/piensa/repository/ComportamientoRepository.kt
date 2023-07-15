package com.example.piensa.repository
import com.example.piensa.model.Comportamiento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ComportamientoRepository: JpaRepository<Comportamiento, Long> {
    fun findById(id: Long?): Comportamiento?
}