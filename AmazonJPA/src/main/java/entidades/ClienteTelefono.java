package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class ClienteTelefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public ClienteTelefono() {
    }

    public ClienteTelefono(Long id, String telefono, Cliente cliente) {
        this.id = id;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ClienteTelefono other = (ClienteTelefono) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ClienteTelefono{" + "id=" + id + ", telefono=" + telefono + ", cliente=" + cliente + '}';
    }

}
