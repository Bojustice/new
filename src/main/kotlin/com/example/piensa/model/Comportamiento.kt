package com.example.piensa.model
import jakarta.persistence.*
import java.sql.Timestamp
import javax.validation.constraints.NotBlank


@Entity
@Table(name="Comportamiento")
class Comportamiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank
    var fecha: String?= null
    var inatencion: Long? = null
    var inatencion2: Long? = null
    var hiperactividad: Long? = null
    var hiperactividad2: Long? = null
    var hiperactividad3: Long? = null
    var comentarios: Long? = null
    @NotBlank
    @Column(name="alumnos_id")
    var alumnosId: Long? = null
    @NotBlank
    @Column(name="profesor_id")
    var profesorId: Long? = null


}