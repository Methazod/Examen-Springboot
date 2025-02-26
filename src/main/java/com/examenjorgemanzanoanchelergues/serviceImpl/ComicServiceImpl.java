package com.examenjorgemanzanoanchelergues.serviceImpl;

/**
 * Service del usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.examenjorgemanzanoanchelergues.models.Comic;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.repositories.ComicRepository;
import com.examenjorgemanzanoanchelergues.services.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    /**
     * Repositorio del comic
     */
    @Autowired // Inyeccion de depencia del repositorio
    private ComicRepository repository;

    /**
     * Devuelve todos los comics
     *
     * @return todos los comics
     */
    public List<Comic> getAllComics() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade un nuevo comic
     *
     * @param newComic el nuevo comic
     * @return el nuevo comic
     */
    public Comic newComic(@RequestBody Comic newComic) {
        return repository.save(newComic);
    }

    /**
     * Obtiene todos los superheroes de un comic especifico
     *
     * @param comicId el comic
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroesByComic(Long comicId) {
        return repository.findById(comicId).get().getSuperheroes();
    }
}
