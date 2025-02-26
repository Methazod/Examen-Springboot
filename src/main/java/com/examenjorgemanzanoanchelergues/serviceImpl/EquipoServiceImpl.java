package com.examenjorgemanzanoanchelergues.serviceImpl;

/**
 * Implementacion del service del evento
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Equipo;
import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.repositories.EquipoRepository;
import com.examenjorgemanzanoanchelergues.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    /**
     * Repositorio del equipo
     */
    @Autowired // Inyeccion de depencia del repositorio
    private EquipoRepository repository;

    /**
     * Devuelve todos los eventos
     *
     * @return todos los eventos
     */
    public List<Equipo> getAllEquipos() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade un nuevo evento
     *
     * @param newEquipo el nuevo evento
     * @return el nuevo evento
     */
    public Equipo newEquipo(@RequestBody Equipo newEquipo) {
        return repository.save(newEquipo);
    }

    /**
     * Obtiene todos los superheroes con un equipo especifico
     *
     * @param equipoId el equipo
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroesByEquipo(Long equipoId) {
        return repository.findById(equipoId).get().getSuperheroes();
    }

    /**
     * Obtiene todos los equipos con al menos 2 integrantes
     *
     * @return los equipos
     */
    public List<Equipo> getEquiposBySize(){
        List<Equipo> equipos = new ArrayList<>();
        for (Equipo equipo : repository.findAll()) {
            if (equipo.getSuperheroes() != null && equipo.getSuperheroes().size() >= 2)
                equipos.add(equipo);
        }
        return equipos;
    }
}
