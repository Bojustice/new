CREATE TABLE IF NOT EXISTS comportamiento (
    id SERIAL,
    fecha DATE NOT NULL ,
    inatencion INT ,
    inatencion2 INT ,
    hiperactividad INT ,
    hiperactividad2 INT ,
    hiperactividad3 INT ,
    comentarios VARCHAR(500),
    alumnos_id INT NOT NULL,
    profesor_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (alumnos_id)
    REFERENCES alumnos(id),
    FOREIGN KEY (profesor_id)
    REFERENCES profesor(id)

);