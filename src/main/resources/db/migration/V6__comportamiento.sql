CREATE TABLE IF NOT EXISTS comportamiento (
    id SERIAL,
    fecha DATE NOT NULL,
    alumnos_id INT NOT NULL,
    parametros_id INT NOT NULL,
    curso_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (alumnos_id)
    REFERENCES alumnos(id),
    FOREIGN KEY (parametros_id)
    REFERENCES parametros(id),
    FOREIGN KEY (curso_id)
    REFERENCES curso(id)
);