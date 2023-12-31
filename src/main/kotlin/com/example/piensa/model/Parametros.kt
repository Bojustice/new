package com.example.piensa.model

import jakarta.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="Parametros")
class Parametros {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    var inatencion: Long? = null
    var inatencion2: Long? = null
    var hiperactividad: Long? = null
    var hiperactividad2: Long? = null
    var hiperactividad3: Long? = null
}