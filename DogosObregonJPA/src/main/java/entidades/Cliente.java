package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCliente;

    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Integer edad;
    private String fchNac;
    private String preferencias;

    @ElementCollection
    private List<String> telefonos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long numCliente, String nombre, String apPaterno, String apMaterno, Integer edad, String fchNac, String preferencias, List<String> telefonos, List<Pedido> pedidos) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.fchNac = fchNac;
        this.preferencias = preferencias;
        this.telefonos = telefonos;
        this.pedidos = pedidos;
    }

    public Cliente(Long numCliente, String nombre, String apPaterno, Integer edad, String fchNac, String preferencias, List<String> telefonos, List<Pedido> pedidos) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = null;
        this.edad = edad;
        this.fchNac = fchNac;
        this.preferencias = preferencias;
        this.telefonos = telefonos;
        this.pedidos = pedidos;
    }

    public Long getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(Long numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFchNac() {
        return fchNac;
    }

    public void setFchNac(String fchNac) {
        this.fchNac = fchNac;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.numCliente);
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.numCliente, other.numCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "numCliente=" + numCliente + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", edad=" + edad + ", fchNac=" + fchNac + ", preferencias=" + preferencias + ", telefonos=" + telefonos + ", pedidos=" + pedidos + '}';
    }

}
