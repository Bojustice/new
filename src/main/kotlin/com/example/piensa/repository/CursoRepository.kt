package com.example.piensa.repository
import com.example.piensa.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository

interface CursoRepository: JpaRepository<Curso, Long> {
    fun findById(id: Long?): Curso?
}