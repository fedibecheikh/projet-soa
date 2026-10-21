package com.fedi.equipe.equipe;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fedi.equipe.equipe.entities.Equipe;
import com.fedi.equipe.equipe.entities.Ligue;
import com.fedi.equipe.equipe.repo.EquipeRepository;
import com.fedi.equipe.equipe.repo.LigueRepository;
import com.fedi.equipe.equipe.service.EquipeService;

@SpringBootTest
class EquipeApplicationTests {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private LigueRepository ligueRepository;

    @Autowired
    private EquipeService equipeService;


    // =========================
    // CREER UNE LIGUE
    // =========================

    @Test
    public void testCreateLigue() {

        Ligue ligue = new Ligue();

        ligue.setNomLigue("Liga");
        ligue.setPays("Espagne");
        ligue.setDescription("Championnat espagnol");

        ligueRepository.save(ligue);
    }


    // =========================
    // CREER UNE EQUIPE
    // =========================

    @Test
    public void testCreateEquipe() {

        Ligue ligue = ligueRepository.findAll().stream().findFirst().orElseGet(() -> {
            Ligue l = new Ligue();
            l.setNomLigue("Liga");
            l.setPays("Espagne");
            l.setDescription("Championnat espagnol");
            return ligueRepository.save(l);
        });

        Equipe equipe = new Equipe(
                "Real Madrid",
                "Madrid",
                25,
                2500000.50,
                true,
                new Date()
        );

        equipe.setLigue(ligue);

        equipeRepository.save(equipe);
    }


    // =========================
    // RECHERCHE PAR ID
    // =========================

    @Test
    public void testFindEquipe() {

        Equipe first = equipeRepository.findAll().stream().findFirst().orElse(null);
        if (first != null) {
            Equipe e = equipeRepository.findById(first.getIdEquipe()).orElse(null);
            System.out.println(e);
        }
    }


    // =========================
    // MODIFIER
    // =========================

    @Test
    public void testUpdateEquipe() {

        Equipe e = equipeRepository.findAll().stream().findFirst().orElse(null);
        if (e != null) {
            e.setNomEquipe("FC Barcelona");
            e.setVille("Barcelona");
            e.setNombreJoueurs(28);
            e.setBudget(3000000.00);
            e.setActive(true);
            e.setDateCreation(new Date());

            equipeRepository.save(e);
        }
    }


    // =========================
    // SUPPRIMER
    // =========================

    @Test
    public void testDeleteEquipe() {

        List<Equipe> equipes = equipeRepository.findAll();
        if (!equipes.isEmpty()) {
            equipeRepository.deleteById(equipes.get(equipes.size() - 1).getIdEquipe());
        }
    }


    // =========================
    // LISTER
    // =========================

    @Test
    public void testListerToutesEquipes() {

        List<Equipe> equipes = equipeRepository.findAll();

        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


    // =========================
    // findByNomEquipe
    // =========================

    @Test
    public void testFindByNomEquipe() {

        List<Equipe> equipes =
                equipeRepository.findByNomEquipe("Real Madrid");

        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


    // =========================
    // findByNomEquipeContains
    // =========================

    @Test
    public void testFindByNomEquipeContains() {

        List<Equipe> equipes =
                equipeRepository.findByNomEquipeContains("Real");

        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


   

    // =========================
    // findByLigue
    // =========================

    @Test
    public void testFindByLigue() {

        Ligue ligue = ligueRepository.findAll().stream().findFirst().orElse(null);
        if (ligue != null) {
            List<Equipe> equipes =
                    equipeRepository.findByLigue(ligue);

            for (Equipe e : equipes) {
                System.out.println(e);
            }
        }
    }


    // =========================
    // findByLigueIdLigue
    // =========================

    @Test
    public void testFindByLigueIdLigue() {

        Ligue ligue = ligueRepository.findAll().stream().findFirst().orElse(null);
        if (ligue != null) {
            List<Equipe> equipes =
                    equipeRepository.findByLigueIdLigue(ligue.getIdLigue());

            for (Equipe e : equipes) {
                System.out.println(e);
            }
        }
    }


    // =========================
    // TRI PAR NOM
    // =========================

    @Test
    public void testFindByOrderByNomEquipeAsc() {

        List<Equipe> equipes =
                equipeRepository.findByOrderByNomEquipeAsc();

        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


    // =========================
    // TRI NOM + BUDGET
    // =========================

    @Test
    public void testTrierEquipesNomsBudget() {

        List<Equipe> equipes =
                equipeRepository.trierEquipesNomsBudget();

        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


    // =========================
    // TEST SERVICE
    // =========================

    @Test
    public void testEquipeService() {

        List<Equipe> equipes = equipeService.getAllEquipes();

        for (Equipe e : equipes) {
            System.out.println("Service getAllEquipes: " + e);
        }
    }
}