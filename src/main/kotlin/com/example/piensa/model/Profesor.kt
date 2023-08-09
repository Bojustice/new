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
@Table(name="Profesor")
class Profesor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null

    var nombres: String? = null

    var apellidos: String? = null

    var telefono: Long? = null
    @Email(message= "Formato incorrecto")

    var email: String? = null

    var imagen: String? = null
}