package com.example.piensa.model
import jakarta.persistence.*

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name="Alumnos")
class Alumnos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var nombres: String? = null
    @NotBlank(message="Obligatorio")
    var apellidos: String? = null
    @NotBlank(message="Obligatorio")
    var telefono: Long? = null
    @Email(message= "Formato incorrecto")
    @NotBlank(message="Obligatorio")
    var email: String? = null
    @NotBlank
    var imagen: String? = null
}