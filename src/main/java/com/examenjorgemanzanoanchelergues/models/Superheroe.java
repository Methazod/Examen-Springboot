package com.examenjorgemanzanoanchelergues.models;

/**
 * Modelo del Superheroe
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "superheroes")
public class Superheroe {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre del superheroe
     */
    private String nombre;

    /**
     * Poder de los superheroes
     */
    private String poder;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Equipo del superheroes
     */
    @JsonIgnoreProperties("superheroes")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id") // id del equipo en la tabla superheroes
    private Equipo equipo;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Comics donde aparece el heroe
     */
    @JsonIgnoreProperties("superheroes")
    @ManyToMany(mappedBy = "superheroes") // nombre de la lista de la clase Usuario
    private List<Comic> comics = new ArrayList<>();

    /**
     * Construye el superheroe
     */
    public Superheroe() {}

    /**
     * Construye el superheroe
     *
     * @param nombre nombre del superheroe
     * @param poder poder del superheroe
     */
    public Superheroe(String nombre, String poder) {
        this.nombre = nombre;
        this.poder = poder;
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
    public String getNombre() { return this.nombre; }

    /**
     * Getter del poder
     *
     * @return el poder
     */
    public String getPoder() {
        return this.poder;
    }

    /**
     * Getter del equipo
     *
     * @return el equipo
     */
    public Equipo getEquipo() { return equipo; }

    /**
     * Getter de los comics
     *
     * @return los comics
     */
    public List<Comic> getComics() { return comics; }

    /**
     * Setter del id
     *
     * @param id el nuevo id
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Setter del nombre
     *
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Setter del poder
     *
     * @param poder el nuevo poder
     */
    public void setPoder(String poder) { this.poder = poder; }

    /**
     * Setter del equipo
     *
     * @param equipo el nuevo equipo
     */
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    /**
     * Setter de los comics
     *
     * @param comics los nuevos comics
     */
    public void setComics(List<Comic> comics) { this.comics = comics; }

    /**
     * Compara una reserva con esta reserva
     *
     * @param o la reserva a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Superheroe))
            return false;
        Superheroe superheroe = (Superheroe) o;
        return Objects.equals(this.id, superheroe.id)
            && Objects.equals(this.nombre, superheroe.nombre)
            && Objects.equals(this.poder, superheroe.poder)
            && Objects.equals(this.equipo, superheroe.equipo)
            && Objects.equals(this.comics, superheroe.comics);
    }

    /**
     * Metodo que devuelve el hash del superheroe
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.poder, this.equipo, this.comics);
    }

    /**
     * Metodo que cambia la impresion de la reserva
     *
     * @return la impresion de la reserva
     */
    @Override
    public String toString() {
        return "Superheroe{" + "id=" + this.id + ", nombre='" + this.nombre + '\''
                + ", poder='" + this.poder + '\'' + '}';
    }
}