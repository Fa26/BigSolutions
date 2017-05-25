package entidad;

import entidad.Puesto;
import entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-25T10:49:50")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Integer> nIdComentario;
    public static volatile SingularAttribute<Comentario, String> texto;
    public static volatile SingularAttribute<Comentario, Usuario> nIdUsuario;
    public static volatile SingularAttribute<Comentario, Date> fecha;
    public static volatile SingularAttribute<Comentario, Puesto> nIdPuesto;

}