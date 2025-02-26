package com.examenjorgemanzanoanchelergues.repositories;

/**
 * Repositorio del evento
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

}