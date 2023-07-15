package com.example.piensa.repository

import com.example.piensa.model.Profesor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ProfesorRepository: JpaRepository<Profesor, Long> {
    fun findById(id: Long?): Profesor?
}
