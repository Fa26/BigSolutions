package entidad;

import entidad.CalificacionPK;
import entidad.Puesto;
import entidad.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-25T10:49:50")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, Puesto> puesto;
    public static volatile SingularAttribute<Calificacion, Integer> calificacion;
    public static volatile SingularAttribute<Calificacion, CalificacionPK> calificacionPK;
    public static volatile SingularAttribute<Calificacion, Usuario> usuario;

}