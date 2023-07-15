package com.example.piensa.model
import jakarta.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table
class Comportamiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank
    var fecha: String? = null
    @NotBlank
    @Column(name="alumnos_id")
    var alumnosId: Long? = null
    @NotBlank
    @Column(name="parametros_id")
    var parametrosId: Long? = null
    @NotBlank
    @Column(name="curso_id")
    var cursoId: Long? = null

}