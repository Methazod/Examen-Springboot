package com.examenjorgemanzanoanchelergues.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Modelo del comic
 *
 * @author Jorge Manzano Anchelergues
 */
@Entity @Table(name = "comics")
public class Comic {

    /**
     * Id del Comic
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * titulo del comic
     */
    private String titulo;

    /**
     * Año de publicacion del comic
     */
    private int anio_publicacion;

    /**
     * Superheroes del comic
     */
    @JsonIgnoreProperties("comics")
    @ManyToMany
    @JoinTable(
            name = "superheroes_comics", // nombre tabla intermedia
            joinColumns = @JoinColumn(name = "comic_id"), // id del comic de la tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "superheroe_id") // id del superheroe de la tabla intermedia
    )
    private List<Superheroe> superheroes = new ArrayList<>();

    /**
     * Construye un Usuario
     */
    public Comic() {}

    /**
     * Construye un Usuario
     *
     * @param titulo del usuario
     * @param anio_publicacion del usuario
     */
    public Comic(String titulo, int anio_publicacion) {
        this.titulo = titulo;
        this.anio_publicacion = anio_publicacion;
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
     * @return el titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Getter del año de publicacion
     *
     * @return el año de publicacion
     */
    public int getAnioPublicacion() {
        return this.anio_publicacion;
    }

    /**
     * Getter de los superheroes
     *
     * @return los superheroes
     */
    public List<Superheroe> getSuperheroes() { return this.superheroes; }

    /**
     * Setter del id
     *
     * @param id el nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter del Titulo
     *
     * @param titulo el nuevo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Setter del año de publicacion
     *
     * @param anio_publicacion nuevo año de publicacion
     */
    public void setAnioPublicacion(int anio_publicacion) { this.anio_publicacion = anio_publicacion; }

    /**
     * Setter de los superheroes
     *
     * @param superheroes nuevos superheroes
     */
    public void setSuperheroes(List<Superheroe> superheroes) { this.superheroes = superheroes; }

    /**
     * Metodo que compara un usuario con este
     *
     * @param o el usuario a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Comic))
            return false;
        Comic comic = (Comic) o;
        return Objects.equals(this.id, comic.id)
            && Objects.equals(this.titulo, comic.titulo)
            && Objects.equals(this.anio_publicacion, comic.anio_publicacion)
            && Objects.equals(this.superheroes, comic.superheroes);
    }

    /**
     * Metodo que devuelve el hash del usuario
     *
     * @return el hash del usuario
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.titulo, this.anio_publicacion, this.superheroes);
    }

    /**
     * Metodo que cambia la salida estandar al imprimir el usuario
     *
     * @return el usuario imprimido
     */
    @Override
    public String toString() {
        return "Comic{" + "id=" + this.id + ", nombre='" + this.titulo + '\''
                + ", año de publicacion='" + this.anio_publicacion + '\'' + '}';
    }
}