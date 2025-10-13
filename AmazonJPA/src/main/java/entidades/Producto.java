package entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author brand
 */
@Entity
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String descripcion;
    private Double precio;
    private Integer stock;
    private String cod_barras;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<PedidoProducto> pedidoProductos;

    // getters y setters
}