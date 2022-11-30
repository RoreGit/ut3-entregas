package org.entregas3.elementos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="videojuegos")
public class Videojuego implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String estudio;
    @Column(name="año")
    private int year;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="FK_Director",referencedColumnName = "id")
    private Director director;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="videojuegos_desarrolladores",
            joinColumns = {@JoinColumn(name="FK_videojuego", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="FK_desarrolladores",referencedColumnName = "id")})
    private List<Desarrollador> desarrolladores;

    public Videojuego(String nombre, String estudio, int year, Director director, List<Desarrollador> desarrolladores) {
        this.nombre = nombre;
        this.estudio = estudio;
        this.year = year;
        this.director = director;
        this.desarrolladores = desarrolladores;
    }

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public Videojuego() {
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudio='" + estudio + '\'' +
                ", year=" + year +
                ", director=" + director +
                '}';
    }
}
