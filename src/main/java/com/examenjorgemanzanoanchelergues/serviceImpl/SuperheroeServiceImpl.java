package com.examenjorgemanzanoanchelergues.serviceImpl;

/**
 * Implementacion del Service de la Superheroe
 *
 * @author Jorge Manzano Anchelergues
 */

import com.examenjorgemanzanoanchelergues.models.Superheroe;
import com.examenjorgemanzanoanchelergues.repositories.SuperheroeRepository;
import com.examenjorgemanzanoanchelergues.services.SuperheroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroeServiceImpl implements SuperheroeService {

    /**
     * Repo de superheroes
     */
    @Autowired
    private SuperheroeRepository repository;

    /**
     * Devuelve todos los superheroes
     *
     * @return los superheroes
     */
    public List<Superheroe> getAllSuperheroes() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade un nuevo superheroe
     *
     * @param newSuperheroe el nuevo superheroe
     * @return el nuevo superheroe
     */
    public Superheroe newSuperheroe(@RequestBody Superheroe newSuperheroe) {
        return repository.save(newSuperheroe);
    }

    /**
     * Obtiene una superheroe
     *
     * @param id id del superheroe a buscar
     * @return el superheroe
     */
    public Superheroe getSuperheroe(@PathVariable Long id) {
        return repository.findById(id).get();
        // return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * Sustituye una superheroe
     *
     * @param newSuperheroe la nuevo superheroe
     * @param id el id del superheroe a sustituir
     * @return wl superheroe sustituido
     */
    public Superheroe replaceSuperheroe(@RequestBody Superheroe newSuperheroe, @PathVariable Long id) {
        return repository.findById(id)
                .map(superheroe -> {
                    superheroe.setNombre(newSuperheroe.getNombre());
                    superheroe.setPoder(newSuperheroe.getPoder());
                    superheroe.setComics(newSuperheroe.getComics());
                    superheroe.setEquipo(newSuperheroe.getEquipo());
                    return repository.save(superheroe);
                })
                .orElseGet(() -> {
                    return repository.save(newSuperheroe);
                });
    }

    /**
     * Borra una superheroe
     *
     * @param id id del superheroe a borrar
     */
    public void deleteSuperheroe(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public List<Superheroe> getSuperheroesByComicRepeatTimes() {
        List<Superheroe> superheroes = new ArrayList<Superheroe>();
        for (Superheroe superheroe : repository.findAll()) {
            if (superheroe.getComics() != null && superheroe.getComics().size() > 3)
                superheroes.add(superheroe);
        }
        return superheroes;
    }
}
