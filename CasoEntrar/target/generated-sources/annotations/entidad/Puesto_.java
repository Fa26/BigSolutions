package entidad;

import entidad.Administrador;
import entidad.Calificacion;
import entidad.Comentario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-25T10:49:50")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, Date> horaApertura;
    public static volatile SingularAttribute<Puesto, String> appDuenio;
    public static volatile SingularAttribute<Puesto, byte[]> foto;
    public static volatile SingularAttribute<Puesto, Administrador> nIdAdministrador;
    public static volatile SingularAttribute<Puesto, Integer> nIdPuesto;
    public static volatile SingularAttribute<Puesto, String> nomDuenio;
    public static volatile SingularAttribute<Puesto, Date> horaCierre;
    public static volatile SingularAttribute<Puesto, String> apmDuenio;
    public static volatile SingularAttribute<Puesto, String> tipoComida;
    public static volatile SingularAttribute<Puesto, String> nombre;
    public static volatile CollectionAttribute<Puesto, Calificacion> calificacionCollection;
    public static volatile CollectionAttribute<Puesto, Comentario> comentarioCollection;

}