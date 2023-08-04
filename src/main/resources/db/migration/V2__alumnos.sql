CREATE TABLE if NOT EXISTS alumnos (
  id SERIAL,
  nombres VARCHAR (50) NOT NULL,
  apellidos VARCHAR (50) NOT NULL,
  telefono INT NOT NULL,
  email VARCHAR (50) NOT NULL,
  imagen VARCHAR (200) NOT NULL,
  PRIMARY KEY (id)
);