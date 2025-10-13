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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategoria;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "categorias")
    private List<Libro> libros;

    public Categoria() {
    }

    public Categoria(Integer idcategoria, String nombre, List<Libro> libros) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.libros = libros;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idcategoria);
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
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.idcategoria, other.idcategoria);
    }

    @Override
    public String toString() {
        return "Categoria{" + "idcategoria=" + idcategoria + ", nombre=" + nombre + ", libros=" + libros + '}';
    }

}
