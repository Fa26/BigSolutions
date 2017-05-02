/* ---------------------------------------------------------------------- */
/* Target DBMS:           MySQL						                      */
/* Project file:          creaEsquema.sql	                              */
/* Project name:          FoodCiencias                                    */
/* Author:                Andrés López Martínez                           */
/*						  andoresu@ciencias.unam.mx		                  */
/* Script type:           Script de creacion de tablas                    */
/* Created on:            2017-03-30 10:10                                */
/* ---------------------------------------------------------------------- */

use bigsolutions;

-- Tabla de usuario
CREATE TABLE Usuario(
	nIdUsuario		INT				AUTO_INCREMENT		,
	correo 			VARCHAR(128)	NOT NULL			,
	contrasenia		VARCHAR(128)	NOT NULL			,
	nombre			VARCHAR(64)		NOT NULL			,
	app				VARCHAR(32)		NOT NULL			,
	apm				VARCHAR(32)		NOT NULL			,
	foto			LONGBLOB							,
	CONSTRAINT pk_usuario PRIMARY KEY (nIdUsuario),
	CONSTRAINT uq_usuario UNIQUE (correo)
);

-- Tabla de Administrador
CREATE TABLE Administrador(
	nIdAdministrador		INT				AUTO_INCREMENT		,
	correo 					VARCHAR(128)	NOT NULL			,
	contrasenia				VARCHAR(128)	NOT NULL			,
	CONSTRAINT pk_administrador PRIMARY KEY (nIdAdministrador)	,
	CONSTRAINT uq_administrador UNIQUE (correo)
);

-- Tabla de Puesto
CREATE TABLE Puesto(
	nIdPuesto			INT				AUTO_INCREMENT		,
	hora_apertura		TIME								,
	hora_cierre			TIME								,
	tipo_comida			VARCHAR(32)		NOT NULL			,
	nombre 				VARCHAR(32)		NOT NULL			,
	nom_duenio			VARCHAR(64)		NOT NULL			,
	app_duenio			VARCHAR(32)							,
	apm_duenio			VARCHAR(32)							,
	foto				LONGBLOB							,
	nIdAdministrador	INT									,
	CONSTRAINT pk_puesto PRIMARY KEY (nIdPuesto)			,
	CONSTRAINT fk_puesto_administrador 	FOREIGN KEY (nIdAdministrador) 	REFERENCES Administrador(nIdAdministrador)	ON DELETE SET NULL
);

-- Tabla de calificacion
CREATE TABLE Calificacion(
	nIdUsuario				INT							,
	nIdPuesto				INT							, 
	calificacion			INT(1)		NOT NULL		,
	CONSTRAINT pk_calificacion PRIMARY KEY (nIdUsuario, nIdPuesto),
	CONSTRAINT fk_calificacion_usuario 	FOREIGN KEY (nIdUsuario) 	REFERENCES Usuario(nIdUsuario)	ON DELETE CASCADE,
	CONSTRAINT fk_calificacion_puesto 	FOREIGN KEY (nIdPuesto) 	REFERENCES Puesto(nIdPuesto)	ON DELETE CASCADE
);

-- Tabla de Comentario
CREATE TABLE Comentario(
	nIdComentario		INT		AUTO_INCREMENT		,
	fecha				DATE	NOT NULL			,
	texto 				TEXT	NOT NULL			,
	nIdPuesto			INT		NOT NULL			,
	nIdUsuario			INT							,
	CONSTRAINT pk_comentario 			PRIMARY KEY (nIdComentario),
	CONSTRAINT fk_comentario_puesto 	FOREIGN KEY (nIdPuesto) 		REFERENCES Puesto(nIdPuesto)			ON DELETE CASCADE,
	CONSTRAINT fk_comentario_usuario 	FOREIGN KEY (nIdUsuario) 		REFERENCES Usuario(nIdUsuario)			ON DELETE SET NULL
);
