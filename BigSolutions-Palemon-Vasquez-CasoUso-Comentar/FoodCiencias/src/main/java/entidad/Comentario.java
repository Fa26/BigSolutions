/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FaVenegas
 */
@Entity
@Table(name = "Comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByNIdComentario", query = "SELECT c FROM Comentario c WHERE c.nIdComentario = :nIdComentario")
    , @NamedQuery(name = "Comentario.findByFecha", query = "SELECT c FROM Comentario c WHERE c.fecha = :fecha")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIdComentario")
    private Integer nIdComentario;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "texto")
    private String texto;

    public Comentario() {
    }

    public Comentario(Integer nIdComentario) {
        this.nIdComentario = nIdComentario;
    }

    public Integer getNIdComentario() {
        return nIdComentario;
    }

    public void setNIdComentario(Integer nIdComentario) {
        this.nIdComentario = nIdComentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdComentario != null ? nIdComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.nIdComentario == null && other.nIdComentario != null) || (this.nIdComentario != null && !this.nIdComentario.equals(other.nIdComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Comentario[ nIdComentario=" + nIdComentario + " ]";
    }
    
}
