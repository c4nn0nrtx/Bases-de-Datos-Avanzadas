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
public class HotDog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @OneToMany(mappedBy = "hotDog", cascade = CascadeType.ALL)
    private List<PedidoHotDog> pedidoHotDogs;

    public HotDog() {
    }

    public HotDog(Long id, String nombre, Double precio, List<PedidoHotDog> pedidoHotDogs) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.pedidoHotDogs = pedidoHotDogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<PedidoHotDog> getPedidoHotDogs() {
        return pedidoHotDogs;
    }

    public void setPedidoHotDogs(List<PedidoHotDog> pedidoHotDogs) {
        this.pedidoHotDogs = pedidoHotDogs;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final HotDog other = (HotDog) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "HotDog{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", pedidoHotDogs=" + pedidoHotDogs + '}';
    }

}
