package com.examenjorgemanzanoanchelergues.controllers;

/**
 * Clase que implementa el controlador de un superheroe
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.serviceImpl.SuperheroeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class SuperheroeController {

    /**
     * Link with superheroes service
     */
    @Autowired
    private SuperheroeServiceImpl superheroeService;

    /**
     * Get method to obtain all superheroes
     * @return a list of all superheroes stored in the database
     */
    @GetMapping("/superheroes")
    public List<Superheroe> getAllSuperheroes() { return superheroeService.getAllSuperheroes(); }

    /**
     * Obtiene una superheroe
     *
     * @param id id del superheroe a buscar
     * @return el superheroe
     */
    @GetMapping("/superheroes/{id}")
    public Superheroe getSuperheroe(@PathVariable Long id) { return superheroeService.getSuperheroe(id); }

    /**
     * Post method to insert a new superheroe
     * @param json Contains the new superheroes to be inserted
     * @return the new superheroes added to the database in json format
     */
    @PostMapping("/superheroes")
    public Superheroe newSuperheroe(@RequestBody Superheroe json) {
        return superheroeService.newSuperheroe(json);
    }

    /**
     * Sustituye una superheroe
     *
     * @param newSuperheroe la nuevo superheroe
     * @param id el id del superheroe a sustituir
     * @return wl superheroe sustituido
     */
    @PutMapping("/superheroes/{id}")
    public Superheroe replaceSuperheroe(@RequestBody Superheroe newSuperheroe, @PathVariable Long id) {
        return superheroeService.replaceSuperheroe(newSuperheroe, id);
    }

    /**
     * Delete method to replace a specific superheroe
     * @param id identifier of the superheroes you want to delete
     */
    @DeleteMapping("/superheroes/{id}")
    public void deleteSuperheroe(@PathVariable Long id) {
        superheroeService.deleteSuperheroe(id);
    }

    /**
     * Obtiene una lista de superheroes que aparezcan en 3 o mas comics
     *
     * @return los superheroes
     */
    @GetMapping("/superheroes/populares")
    public List<Superheroe> getSuperheroesByComicRepeatTimes() {
        return superheroeService.getSuperheroesByComicRepeatTimes();
    }
}