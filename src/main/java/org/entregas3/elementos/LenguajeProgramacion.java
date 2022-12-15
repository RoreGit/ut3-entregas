package org.entregas3.elementos;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "lenguajes",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value="L")
public class LenguajeProgramacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column
    protected String lenguaje;

    public LenguajeProgramacion() {
    }

    public LenguajeProgramacion(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getId() {
        return id;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String nombre) {
        this.lenguaje = nombre;
    }

    @Override
    public String toString() {
        return "LenguajeProgramacion{" +
                "id=" + id +
                ", nombre='" + lenguaje + '\'' +
                '}';
    }
}
