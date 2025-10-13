package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class Credencial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcredencial;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "usuarioid", nullable = false, unique = true)
    private Usuario usuario;

    public Credencial() {
    }

    public Credencial(Integer idcredencial, String username, String password, Usuario usuario) {
        this.idcredencial = idcredencial;
        this.username = username;
        this.password = password;
        this.usuario = usuario;
    }

    public Integer getIdcredencial() {
        return idcredencial;
    }

    public void setIdcredencial(Integer idcredencial) {
        this.idcredencial = idcredencial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.username);
        hash = 17 * hash + Objects.hashCode(this.password);
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
        final Credencial other = (Credencial) obj;
        return Objects.equals(this.idcredencial, other.idcredencial);
    }

    @Override
    public String toString() {
        return "Credencial{" + "idcredencial=" + idcredencial + ", username=" + username + ", usuario=" + usuario + '}';
    }

}
