CREATE TABLE IF NOT EXISTS materia (
    id SERIAL,
    materia VARCHAR (50) NOT NULL,
    profesor_id INT NOT NULL,
    curso_id INT NOT NULL,
    imagen VARCHAR (200) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (profesor_id)
    REFERENCES profesor(id),
    FOREIGN KEY (curso_id)
    REFERENCES curso(id)
);