package com.fedi.equipe.equipe.service;

import java.util.List;

import com.fedi.equipe.equipe.entities.Equipe;
import com.fedi.equipe.equipe.entities.Ligue;

public interface EquipeService {

    Equipe saveEquipe(Equipe e);

    Equipe updateEquipe(Equipe e);

    void deleteEquipe(Equipe e);

    void deleteEquipeById(Long id);

    Equipe getEquipe(Long id);

    List<Equipe> getAllEquipes();

    List<Equipe> findByNomEquipe(String nom);

    List<Equipe> findByNomEquipeContains(String nom);

    List<Equipe> findByNomBudget(String nom, Double budget);
    

    List<Equipe> findByLigue(Ligue ligue);

    List<Equipe> findByLigueIdLigue(Long id);

    List<Equipe> findByOrderByNomEquipeAsc();

    List<Equipe> trierEquipesNomsBudget();
}