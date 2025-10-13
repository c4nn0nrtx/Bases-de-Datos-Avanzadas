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
    private Long id_cliente;

    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private Integer edad;
    private String fch_nac;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ClienteTelefono> telefonos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ClienteCorreo> correos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String ap_pat, String ap_mat, Integer edad, String fch_nac, List<ClienteTelefono> telefonos, List<ClienteCorreo> correos, List<Pedido> pedidos) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.edad = edad;
        this.fch_nac = fch_nac;
        this.telefonos = telefonos;
        this.correos = correos;
        this.pedidos = pedidos;
    }

    public Cliente(Long id_cliente, String nombre, String ap_pat, Integer edad, String fch_nac, List<ClienteTelefono> telefonos, List<ClienteCorreo> correos, List<Pedido> pedidos) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = null;
        this.edad = edad;
        this.fch_nac = fch_nac;
        this.telefonos = telefonos;
        this.correos = correos;
        this.pedidos = pedidos;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFch_nac() {
        return fch_nac;
    }

    public void setFch_nac(String fch_nac) {
        this.fch_nac = fch_nac;
    }

    public List<ClienteTelefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<ClienteTelefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<ClienteCorreo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<ClienteCorreo> correos) {
        this.correos = correos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id_cliente);
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
        return Objects.equals(this.id_cliente, other.id_cliente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + ", ap_pat=" + ap_pat + ", ap_mat=" + ap_mat + ", edad=" + edad + ", fch_nac=" + fch_nac + ", telefonos=" + telefonos + ", correos=" + correos + ", pedidos=" + pedidos + '}';
    }

}
