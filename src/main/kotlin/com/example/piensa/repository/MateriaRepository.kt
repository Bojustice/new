package com.example.piensa.repository
import com.example.piensa.model.Materia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface MateriaRepository: JpaRepository<Materia, Long> {
    fun findById(id: Long?): Materia?
}