CREATE TABLE if NOT EXISTS alumnos (
  id SERIAL,
  nombres VARCHAR (50) NOT NULL,
  apellidos VARCHAR (50) NOT NULL,
  telefono INT NOT NULL,
  email VARCHAR (50) NOT NULL,
  curso VARCHAR (20),
  PRIMARY KEY (id)
);