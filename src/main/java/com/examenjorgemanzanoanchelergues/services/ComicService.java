package com.examenjorgemanzanoanchelergues.services;

/**
 * Service del usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.examenjorgemanzanoanchelergues.models.Comic;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface ComicService {

    /**
     * Devuelve todos los comics
     *
     * @return los comics
     */
    public List<Comic> getAllComics();

    /**
     * Añade un comic
     *
     * @param newComic el nuevo comic
     * @return el nuevo comic
     */
    public Comic newComic(@RequestBody Comic newComic);

    /**
     * Devuelve todos los superheroes por un comic especifico
     *
     * @param comicId el comic
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroesByComic(Long comicId);
}
