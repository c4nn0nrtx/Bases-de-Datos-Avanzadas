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
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idautor;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Integer idautor, String nombre, String nacionalidad, List<Libro> libros) {
        this.idautor = idautor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idautor);
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
        final Autor other = (Autor) obj;
        return Objects.equals(this.idautor, other.idautor);
    }

    @Override
    public String toString() {
        return "Autor{" + "idautor=" + idautor + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", libros=" + libros + '}';
    }

}
