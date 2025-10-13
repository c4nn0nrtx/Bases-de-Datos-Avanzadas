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
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlibro;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column
    private Integer aniopublicacion;

    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;

    @ManyToMany
    @JoinTable(
            name = "LibroCategoria",
            joinColumns = @JoinColumn(name = "idlibro"),
            inverseJoinColumns = @JoinColumn(name = "idcategoria")
    )
    private List<Categoria> categorias;

    public Libro() {
    }

    public Libro(Integer idlibro, String titulo, Integer aniopublicacion, Autor autor, List<Categoria> categorias) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.aniopublicacion = aniopublicacion;
        this.autor = autor;
        this.categorias = categorias;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAniopublicacion() {
        return aniopublicacion;
    }

    public void setAniopublicacion(Integer aniopublicacion) {
        this.aniopublicacion = aniopublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idlibro);
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
        final Libro other = (Libro) obj;
        return Objects.equals(this.idlibro, other.idlibro);
    }

    @Override
    public String toString() {
        return "Libro{" + "idlibro=" + idlibro + ", titulo=" + titulo + ", aniopublicacion=" + aniopublicacion + ", autor=" + autor + ", categorias=" + categorias + '}';
    }

}
