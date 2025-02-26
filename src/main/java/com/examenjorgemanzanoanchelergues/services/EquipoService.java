package com.examenjorgemanzanoanchelergues.services;

/**
 * Service del evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.examenjorgemanzanoanchelergues.models.Equipo;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface EquipoService {

    /**
     * Devuelve todos los equipos
     *
     * @return todos los equipos
     */
    public List<Equipo> getAllEquipos();

    /**
     * Añade un nuevo equipo
     *
     * @param newEquipo el nuevo equipo
     * @return el nuevo equipo
     */
    public Equipo newEquipo(@RequestBody Equipo newEquipo);

    /**
     * Obtiene todos los superheroes con un equipo especifico
     *
     * @param equipoId el equipo
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroesByEquipo(Long equipoId);

    /**
     * Obtiene todos los equipos con al menos 2 integrantes
     *
     * @return los equipos
     */
    public List<Equipo> getEquiposBySize();
}
