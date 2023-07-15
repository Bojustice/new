package com.example.piensa.model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


@Entity
@Table
class Profesor {
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
}