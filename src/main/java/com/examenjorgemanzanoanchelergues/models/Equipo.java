package com.examenjorgemanzanoanchelergues.models;

/**
 * Modelo del Equipo
 *
 * @author Jorge Manzano Anchelergues
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "equipos")
public class Equipo {

    /**
     * Id del Equipo
     */
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre del Equipo
     */
    private String nombre;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Lista con las reservas de las instalaciones
     */
    @JsonIgnoreProperties("equipo")
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.PERSIST, orphanRemoval = true) // Mapped by guarda el nombre del atributo de la clase
    private List<Superheroe> superheroes = new ArrayList<>();

    /**
     * Construye un equipo
     */
    public Equipo() {}

    /**
     * Construye un equipo
     *
     *
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del id
     *
     * @return el id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter del nombre
     *
     * @return el nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de los superheroes
     *
     * @return los superheroes
     */
    public List<Superheroe> getSuperheroes() {
        return this.superheroes;
    }

    /**
     * Setter del id
     *
     * @param id el id a guardar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter del nombre
     *
     * @param nombre el nombre a guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter de los superheroes
     *
     * @param superheroes los superheroes a guardar
     */
    public void setSuperheroes(ArrayList<Superheroe> superheroes) {
        this.superheroes = superheroes;
    }

    /**
     * Metodo que compara un evento con este
     *
     * @param o el evento a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Equipo))
            return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(this.id, equipo.id)
                && Objects.equals(this.nombre, equipo.nombre)
                && Objects.equals(this.superheroes, equipo.superheroes);
    }

    /**
     * Metodo que devuelve el hash del evento
     *
     * @return el hash del evento
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.superheroes);
    }

    /**
     * Metodo que cambia la salida estandar al imprimir el evento
     *
     * @return el evento imprimido
     */
    @Override
    public String toString() {
        return "Equipo{" + "id=" + this.id + ", nombre='" + this.nombre + '\''
                + ", superheroes='" + this.superheroes + '\''
                + '}';
    }
}
