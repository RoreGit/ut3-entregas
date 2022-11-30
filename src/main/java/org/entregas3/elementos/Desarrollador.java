package org.entregas3.elementos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="desarrolladores")
public class Desarrollador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int horas;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "desarrolladores")
    private List<Videojuego> videojuegos;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="FK_motorGrafico",referencedColumnName = "id")
    private MotorGrafico motor;

    public Desarrollador(String nombre, int horas, List<Videojuego> videojuegos) {
        this.nombre = nombre;
        this.horas = horas;
        this.videojuegos = videojuegos;
    }

    public Desarrollador() {

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

    @Override
    public String toString() {
        return "Desarrollador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", horas=" + horas +
                ", videojuegos=" + videojuegos +
                '}';
    }
}
