package com.fedi.equipe.equipe.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fedi.equipe.equipe.entities.Equipe;
import com.fedi.equipe.equipe.service.EquipeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EquipeRESTController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @GetMapping("/{id}")
    public Equipe getEquipe(@PathVariable Long id) {
        return equipeService.getEquipe(id);
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        if (equipe.getIdEquipe() != null && equipe.getIdEquipe() == 0) {
            equipe.setIdEquipe(null);
        }
        return equipeService.saveEquipe(equipe);
    }

    @PutMapping
    public Equipe updateEquipe(@RequestBody Equipe equipe) {
        return equipeService.updateEquipe(equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipeById(id);
    }

    @GetMapping("/nom/{nom}")
    public List<Equipe> findByNomEquipe(@PathVariable String nom) {
        return equipeService.findByNomEquipe(nom);
    }

    @GetMapping("/nom-contains/{nom}")
    public List<Equipe> findByNomEquipeContains(@PathVariable String nom) {
        return equipeService.findByNomEquipeContains(nom);
    }

    @GetMapping("/equipesByName/{nom}")
    public List<Equipe> findEquipesByName(@PathVariable String nom) {
        return equipeService.findByNomEquipeContains(nom);
    }

    @GetMapping("/equipesligue/{id}")
    public List<Equipe> findByLigueIdLigue(@PathVariable Long id) {
        return equipeService.findByLigueIdLigue(id);
    }

    @GetMapping("/trier")
    public List<Equipe> trierEquipes() {
        return equipeService.findByOrderByNomEquipeAsc();
    }
}