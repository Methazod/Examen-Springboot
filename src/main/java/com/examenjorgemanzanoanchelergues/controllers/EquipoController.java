package com.examenjorgemanzanoanchelergues.controllers;

/**
 * Clase que implementa el controlador de un Equipo
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Equipo;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.serviceImpl.EquipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class EquipoController {

    /**
     * Link with team service
     */
    @Autowired
    private EquipoServiceImpl equipoService;

    /**
     * Get method to obtain all teams
     * @return a list of all teams stored in the database
     */
    @GetMapping("/equipos")
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    /**
     * Post method to insert a new team
     * @param json Contains the new team to be inserted
     * @return the new team added to the database in json format
     */
    @PostMapping("/equipos")
    public Equipo newEquipo(@RequestBody Equipo json) {
        return equipoService.newEquipo(json);
    }

    /**
     * Get method to obtain all superheros by comic
     * @param id team to search
     * @return the superheros
     */
    @PutMapping("/equipos/{id}/superheroes")
    public List<Superheroe> getAllSuperheroesByEquipo(@PathVariable Long id) {
        return equipoService.getAllSuperheroesByEquipo(id);
    }

    /**
     * Get method to obtain all big teams
     *
     * @return a list of all teams stored in the database
     */
    @GetMapping("/equipos/grandes")
    public List<Equipo> getEquiposGrandes() {
        return equipoService.getEquiposBySize();
    }
}