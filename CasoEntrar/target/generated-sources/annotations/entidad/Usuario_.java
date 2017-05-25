package entidad;

import entidad.Calificacion;
import entidad.Comentario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-25T10:49:50")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> nIdUsuario;
    public static volatile SingularAttribute<Usuario, String> app;
    public static volatile SingularAttribute<Usuario, byte[]> foto;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, String> contrasenia;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile CollectionAttribute<Usuario, Calificacion> calificacionCollection;
    public static volatile CollectionAttribute<Usuario, Comentario> comentarioCollection;
    public static volatile SingularAttribute<Usuario, String> apm;

}