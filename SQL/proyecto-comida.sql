--
-- Tabla de comentario
--
DROP TABLE IF EXISTS comentario;
CREATE TABLE comentario (
  idComentario int AUTO_INCREMENT,
  fecha date DEFAULT NULL,
  texto varchar(255) DEFAULT NULL,
  PRIMARY KEY (idComentario)
)engine=InnoDB default charset=utf8;
