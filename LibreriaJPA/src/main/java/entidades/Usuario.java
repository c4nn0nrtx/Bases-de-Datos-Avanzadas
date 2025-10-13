package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String correo;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Credencial credencial;

    public Usuario() {
    }

    public Usuario(Integer idusuario, String nombre, String correo, Credencial credencial) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.correo = correo;
        this.credencial = credencial;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idusuario);
        hash = 79 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nombre=" + nombre + ", correo=" + correo + ", credencial=" + credencial + '}';
    }
}
