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

    @Column
    private String tipo;

    @OneToMany(mappedBy = "motor",cascade = CascadeType.PERSIST)
    private List<Desarrollador> desarrolladores;
    public MotorGrafico() {
        super();
    }

    public MotorGrafico(String nombre1) {
        super();
        this.nombre = nombre1;
    }
    public MotorGrafico(String lenguaje,String nombre,String tipo, List<Desarrollador> desa) {
        super(lenguaje);
        this.nombre = nombre;
        this.desarrolladores = desa;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
