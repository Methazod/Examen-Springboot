package com.examenjorgemanzanoanchelergues.services;

/**
 * Service de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.examenjorgemanzanoanchelergues.models.Superheroe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Date;
import java.util.List;

public interface SuperheroeService {

    /**
     * Devuelve todos los superheroes
     *
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroes();

    /**
     * Obtiene un superheroe
     *
     * @param id el id del superheroe a buscar
     * @return el superheroe
     */
    public Superheroe getSuperheroe(@PathVariable Long id);

    /**
     * Añade una nueva instalacion
     *
     * @param newSuperheroe el nuevo superheroe
     * @return el nuevo superheroe
     */
    public Superheroe newSuperheroe(@RequestBody Superheroe newSuperheroe);

    /**
     * Sustituye un superheroe
     *
     * @param newSuperheroe el nuevo superheroe
     * @param id el id del superheroe a sustituir
     * @return el superheroe sustituido
     */
    public Superheroe replaceSuperheroe(@RequestBody Superheroe newSuperheroe, @PathVariable Long id);

    /**
     * Borra un superheroe
     *
     * @param id el id del superhereo a borrar
     */
    public void deleteSuperheroe(@PathVariable Long id);

    public List<Superheroe> getSuperheroesByComicRepeatTimes();
}
