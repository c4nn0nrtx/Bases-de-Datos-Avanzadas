package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class ClienteCorreo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public ClienteCorreo() {
    }

    public ClienteCorreo(Long id, String correo, Cliente cliente) {
        this.id = id;
        this.correo = correo;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ClienteCorreo other = (ClienteCorreo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ClienteCorreo{" + "id=" + id + ", correo=" + correo + ", cliente=" + cliente + '}';
    }

}
