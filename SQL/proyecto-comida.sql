
--
-- Tabla de comentario
--

DROP TABLE IF EXISTS comentario;

CREATE TABLE comentario (
  idComentario int AUTO_INCREMENT,
  fecha date DEFAULT NULL,
  texto varchar(255) DEFAULT NULL,
  PRIMARY KEY (idComentario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



