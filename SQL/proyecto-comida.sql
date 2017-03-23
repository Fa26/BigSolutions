<<<<<<< 9f59a3e635c1cbdace182ef3009ca636e0cc0692

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
  );

DROP TABLE IF EXISTS comentario;
CREATE TABLE comentario (
  idComentario int AUTO_INCREMENT,
  fecha date DEFAULT NULL,
  texto varchar(255) DEFAULT NULL,
  PRIMARY KEY (idComentario)
);

drop table Puesto;

--Tabla Puesto
CREATE TABLE Puesto(
       nId_puesto   int AUTO_INCREMENT,
       		    nombreDuenio varchar(255),
		    		 nombrePuesto varchar(255),
				 	      menu         varchar(255),
					      		   horario      varchar(255),
							   		tipo_comida  varchar(255),
										     horario      varchar(255),
													PRIMARY KEY (nId_puesto)

);

drop table Administrador;

--Tabla Administrador
CREATE TABLE Administrador(
       idPersona	int
       			usario         varchar(255),
				       correo          varchar(255),
				       		       contrasenia     varchar(30),
						       		       PRIMARY KEY (idPersona)  REFERENCES Persona(idPersona)
								       );

drop table Registrar;

--Tabla Registrar
CREATE TABLE Registrar(
       nid_registro  int AUTO_INCREMENT,
       		     idPersona     int,
		     		   nId_puesto    int,
				   		 PRIMARY KEY (nid_registro),
						 	 FOREIGN KEY (idPersona) REFERENCES Administrador(idPersona),
							 	 FOREIGN KEY (nId_puesto) REFERENCES Puesto(nId_puesto)
);





/*Procedimientos Almacenados*/
--Procedimiento que da de alta un nuevo puesto
create  procedure registra_puesto
	(pnombreD in varchar2 default 'desconocido',pnombreP in varchar2 default 'sin especificar',
		  ptipoComida in varchar2 'sin especificar',pmenu in varchar2 'sin especificar',
		  	      phorario in varchar2 'sin especificar')
			      as
			      begin
				insert into Puesto values(pnombreD,pnombreP,ptipoComida,pmenu,phorario);
				end

--ejecutamos
/*execute registra_puesto('Rafael','LaMuralla','Japonesa','onigiris,ramen','13:00-6:00');
--eliminamos
/*drop procedure registra_puesto;*/


--Procedimiento que elimina un puesto,dando el nombre del propietario o del local
create procedure eliminar_puesto
       @nombreP varchar(50),@puesto varchar(50)
       as
       delete Puesto
       where nombreDuenio=@nombreP and nombrePuesto=@puesto
       end

--Ejecutamos
/*execute eliminar_puesto 'Rafael','Tacos';*/
--Eliminamos
/*drop procedure eliminar_puesto;*/

/*Procedimiento que muestra toda la informacion de un puesto
dado nombre del mismo*/
create procedure muestra_puesto
       @nombreP varchar(30)
       as
        select nombreDuenio,nombrePuesto,tipo_comida,menu,horario
	 from Puesto
	  where nombrePuesto=@nombreP;

 --Ejecutamos
  /*exec muestra_puesto 'Tacos';
 --Eliminamos
 /*drop procedure muestra_puesto;*/

-- Tabla de puestos                                                                                                                                                                                                 
CREATE TABLE Puesto (
    nId_puesto          int AUTO_INCREMENT,
    nombre              varchar(255),
    menu                varchar(255),
    horario             varchar(255),
    tipo_comida                         varchar(255),
        PRIMARY KEY (nId_puesto)
);

-- Tabla de comentarios                                                                                                                                                                                             
CREATE TABLE Comentar(
        nId_comentario  int AUTO_INCREMENT,
        nId_puesto              int,
        nId_usuario             int,
        contenido               varchar(255),
        PRIMARY KEY (nId_comentario),
        FOREIGN KEY (nId_puesto)        REFERENCES Puesto(nId_puesto),
        FOREIGN KEY (nId_usuario)       REFERENCES Usuario(nId_usuario)
);

-- Tabla de usuarios                                                                                                                                                                                                
CREATE TABLE Usuario(
        nId_usuario             int,
        nombre                  varchar(255),
        correo                  varchar(255),
        PRIMARY KEY (nId_usuario)
);



=======
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
>>>>>>> Primera definicion de relaciones para el caso de uso Buscar
