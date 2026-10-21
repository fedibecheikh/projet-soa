package com.fedi.equipe.equipe.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedi.equipe.equipe.entities.Ligue;
import com.fedi.equipe.equipe.repo.LigueRepository;

@RestController
@RequestMapping("/api/ligue")
@CrossOrigin(origins = "*")
public class LigueRESTController {

    @Autowired
    private LigueRepository ligueRepository;

    @GetMapping
    public List<Ligue> getAllLigues() {
        return ligueRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ligue getLigueById(@PathVariable Long id) {
        return ligueRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Ligue createLigue(@RequestBody Ligue ligue) {
        if (ligue.getIdLigue() != null && ligue.getIdLigue() == 0) {
            ligue.setIdLigue(null);
        }
        return ligueRepository.save(ligue);
    }

    @PutMapping
    public Ligue updateLigue(@RequestBody Ligue ligue) {
        return ligueRepository.save(ligue);
    }

    @DeleteMapping("/{id}")
    public void deleteLigue(@PathVariable Long id) {
        ligueRepository.deleteById(id);
    }
}
