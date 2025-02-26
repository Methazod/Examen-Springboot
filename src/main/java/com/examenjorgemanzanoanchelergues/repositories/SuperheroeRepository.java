package com.examenjorgemanzanoanchelergues.repositories;

/**
 * Repositorio de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.examenjorgemanzanoanchelergues.models.Superheroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroeRepository extends JpaRepository<Superheroe, Long> {

}