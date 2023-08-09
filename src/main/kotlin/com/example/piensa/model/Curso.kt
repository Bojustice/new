package com.example.piensa.model
import jakarta.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="Curso")
class Curso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank
    var curso: String? = null
}
