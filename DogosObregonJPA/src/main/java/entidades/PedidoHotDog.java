package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author brand
 */
@Entity
public class PedidoHotDog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "hotdog_id")
    private HotDog hotDog;

    private Integer cantidad;
    private Double subtotal;
    private Double precioVenta;
    private Double iva;

    public PedidoHotDog() {
    }

    public PedidoHotDog(Long id, Pedido pedido, HotDog hotDog, Integer cantidad, Double subtotal, Double precioVenta, Double iva) {
        this.id = id;
        this.pedido = pedido;
        this.hotDog = hotDog;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precioVenta = precioVenta;
        this.iva = iva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public HotDog getHotDog() {
        return hotDog;
    }

    public void setHotDog(HotDog hotDog) {
        this.hotDog = hotDog;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final PedidoHotDog other = (PedidoHotDog) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PedidoHotDog{" + "id=" + id + ", pedido=" + pedido + ", hotDog=" + hotDog + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", precioVenta=" + precioVenta + ", iva=" + iva + '}';
    }

}
