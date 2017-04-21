/* ---------------------------------------------------------------------- */
/* Target DBMS:           MySQL						                      */
/* Project file:          creaEsquema.sql	                              */
/* Project name:          FoodCiencias                                    */
/* Author:                Andrés López Martínez                           */
/*						  andoresu@ciencias.unam.mx		                  */
/* Script type:           Script de creacion de tablas                    */
/* Created on:            2017-03-30 10:10                                */
/* ---------------------------------------------------------------------- */

-- Tabla de usuario
CREATE TABLE Usuario(
	nIdUsuario		INT		AUTO_INCREMENT		,
	usuario			VARCHAR(64)					,
	correo 			VARCHAR(128)				,
	contrasenia		VARCHAR(128)				,
	nombre			VARCHAR(64)					,
	app				VARCHAR(32)					,
	apm				VARCHAR(32)					,
	foto			LONGBLOB					,
	CONSTRAINT pk_usuario PRIMARY KEY (nIdUsuario)
);

-- Tabla de Administrador
CREATE TABLE Administrador(
	nIdAdministrador		INT		AUTO_INCREMENT		,
	usuario					VARCHAR(64)					,
	correo 					VARCHAR(128)				,
	contrasenia				VARCHAR(128)				,
	CONSTRAINT pk_administrador PRIMARY KEY (nIdAdministrador)
);

-- Tabla de Puesto
CREATE TABLE Puesto(
	nIdPuesto			INT		AUTO_INCREMENT		,
	hora_apertura		TIME						,
	hora_cierre			TIME						,
	tipo_comida			VARCHAR(32)					,
	nombre 				VARCHAR(32)					,
	nom_duenio			VARCHAR(64)					,
	app_duenio			VARCHAR(32)					,
	apm_duenio			VARCHAR(32)					,
	foto				LONGBLOB					,
	nIdAdministrador	INT							,
	CONSTRAINT pk_puesto PRIMARY KEY (nIdPuesto)	,
	CONSTRAINT fk_puesto_administrador 	FOREIGN KEY (nIdAdministrador) 	REFERENCES Administrador(nIdAdministrador)	ON DELETE SET NULL
);

-- Tabla de calificacion
CREATE TABLE Calificacion(
	nIdUsuario				INT							,
	nIdPuesto				INT							, 
	calificacion			INT(1)						,
	CONSTRAINT pk_calificacion PRIMARY KEY (nIdUsuario, nIdPuesto),
	CONSTRAINT fk_calificacion_usuario 	FOREIGN KEY (nIdUsuario) 	REFERENCES Usuario(nIdUsuario)	ON DELETE CASCADE,
	CONSTRAINT fk_calificacion_puesto 	FOREIGN KEY (nIdPuesto) 	REFERENCES Puesto(nIdPuesto)	ON DELETE CASCADE
);

-- Tabla de Comentario
CREATE TABLE Comentario(
	nIdComentario		INT		AUTO_INCREMENT		,
	fecha				DATE						,
	texto 				TEXT						,
	nIdPuesto			INT							,
	nIdUsuario			INT							,
	CONSTRAINT pk_comentario 			PRIMARY KEY (nIdComentario),
	CONSTRAINT fk_comentario_puesto 	FOREIGN KEY (nIdPuesto) 		REFERENCES Puesto(nIdPuesto)			ON DELETE CASCADE,
	CONSTRAINT fk_comentario_usuario 	FOREIGN KEY (nIdUsuario) 		REFERENCES Usuario(nIdUsuario)			ON DELETE SET NULL
);
--LLave primaria de comentario
--llave foranea de comentario esnIdPuesto que hace referenia nIdPuesto de Puesto.
--Lave foranea de comentario es nIdUsuario que hace refencia IdUsuario en Usuario.
