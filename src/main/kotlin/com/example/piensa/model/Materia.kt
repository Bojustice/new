package com.example.piensa.model
import jakarta.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
class Materia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank
    var materia: String? = null
    @NotBlank
    @Column(name="profesor_id")
    var profesorId: Long? = null
    @NotBlank
    @Column(name="curso_id")
    var cursoId: Long? = null
    @NotBlank
    var imagen: String? = null
}