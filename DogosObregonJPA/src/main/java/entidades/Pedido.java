package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private Double totalPagar;
    private String metPgo;

    @ManyToOne
    @JoinColumn(name = "numCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoHotDog> pedidoHotDogs;

    public Pedido() {
    }

    public Pedido(Long id, Date fecha, Double totalPagar, String metPgo, Cliente cliente, List<PedidoHotDog> pedidoHotDogs) {
        this.id = id;
        this.fecha = fecha;
        this.totalPagar = totalPagar;
        this.metPgo = metPgo;
        this.cliente = cliente;
        this.pedidoHotDogs = pedidoHotDogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getMetPgo() {
        return metPgo;
    }

    public void setMetPgo(String metPgo) {
        this.metPgo = metPgo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoHotDog> getPedidoHotDogs() {
        return pedidoHotDogs;
    }

    public void setPedidoHotDogs(List<PedidoHotDog> pedidoHotDogs) {
        this.pedidoHotDogs = pedidoHotDogs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", fecha=" + fecha + ", totalPagar=" + totalPagar + ", metPgo=" + metPgo + ", cliente=" + cliente + ", pedidoHotDogs=" + pedidoHotDogs + '}';
    }

}
