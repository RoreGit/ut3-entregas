package org.entregas3.elementos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue(value="G")
@Table(name="motoresgraficos")
public class MotorGrafico extends LenguajeProgramacion {
    @Column
    private String nombre;

    @OneToMany(mappedBy = "motor",cascade = CascadeType.PERSIST)
    private List<Desarrollador> desarrolladores;
    public MotorGrafico() {
        super();
    }

    public MotorGrafico(String nombre1) {
        super();
        this.nombre = nombre1;
    }
    public MotorGrafico(String nombre,String nombre1) {
        super(nombre);
        this.nombre = nombre1;
    }

    @Override
    public String toString() {
        return "MotorGrafico{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
