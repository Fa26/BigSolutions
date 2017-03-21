-- Tabla de puestos
CREATE TABLE Puesto (
    nId_puesto 		int AUTO_INCREMENT,
    nombre 		varchar(255),
    menu 		varchar(255),
    horario 		varchar(255),
    tipo_comida 			varchar(255),
	PRIMARY KEY (nId_puesto)
);

-- Tabla de comentarios
CREATE TABLE Comentar(
	nId_comentario	int AUTO_INCREMENT,
	nId_puesto		int,
	nId_usuario		int,
	contenido		varchar(255),
	PRIMARY KEY (nId_comentario),
	FOREIGN KEY (nId_puesto)	REFERENCES Puesto(nId_puesto),
	FOREIGN KEY (nId_usuario)	REFERENCES Usuario(nId_usuario)
);

-- Tabla de usuarios
CREATE TABLE Usuario(
	nId_usuario		int,
	nombre			varchar(255),
	correo			varchar(255),
	PRIMARY KEY (nId_usuario)
);