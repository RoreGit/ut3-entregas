package org.entregas3.elementos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="directores")
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column(name="nacimiento")
    private int year;

    public Director() {
    }

    public Director(String nombre, int year) {
        this.nombre = nombre;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", year=" + year +
                '}';
    }
}
