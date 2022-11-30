package org.entregas3.elementos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="desarrolladores")
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int horas;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "desarrolladores")
    private List<Videojuego> videojuegos;

    public Desarrollador(String nombre, int horas, List<Videojuego> videojuegos) {
        this.nombre = nombre;
        this.horas = horas;
        this.videojuegos = videojuegos;
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
