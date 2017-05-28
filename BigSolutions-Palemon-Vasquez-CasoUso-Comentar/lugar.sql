

create table if not exists lugar (
  id int AUTO_INCREMENT,
  latitud varchar(20) not null,
  longitud varchar(20) not null,
  nombre varchar(255) not null unique,
  nIdPuesto int,
  CONSTRAINT pk_lugar primary key (id),
  CONSTRAINT fk_lugar_Puesto FOREIGN KEY (nIdPuesto) REFERENCES Puesto(nIdPuesto) ON DELETE SET NULL);