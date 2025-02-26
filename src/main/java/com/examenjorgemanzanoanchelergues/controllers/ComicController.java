package com.examenjorgemanzanoanchelergues.controllers;

/**
 * Clase que implementa el controlador de un Comic
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Comic;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.serviceImpl.ComicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class ComicController {

    /**
     * Link with usuario service
     */
    @Autowired
    private ComicServiceImpl comicService;

    /**
     * Get method to obtain all comics
     * @return a list of all comics stored in the database
     */
    @GetMapping("/comics")
    public List<Comic> getAllComics() {
        return comicService.getAllComics();
    }

    /**
     * Post method to insert a new comic
     * @param json Contains the new comic to be inserted
     * @return the new comic added to the database in json format
     */
    @PostMapping("/comics")
    public Comic newComic(@RequestBody Comic json) {
        return comicService.newComic(json);
    }

    /**
     * Get method to obtain all superheros by comic
     * @param id the comic to search
     * @return the superheros
     */
    @PutMapping("/comics/{id}/superheroes")
    public List<Superheroe> getAllSuperheroesByComic(@PathVariable Long id) {
        return comicService.getAllSuperheroesByComic(id);
    }
}